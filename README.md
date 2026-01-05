# mzHash32
Strong, fast, simple, non-cryptography hash function

```C
uint32_t mzhash32(const void* data, size_t length, uint32_t seed)
{
	const int8_t *bytes = (const int8_t*)data;
	uint32_t hash = 0x514430D1 ^ seed;

	while(length--)
		hash = 0x003C50DB * (*bytes++ ^ hash * 2 ^ hash / 2);

	return hash;
}
```
## Uniform distribution of hash values (diffusion)
It has an absolutely uniform, chaotic distribution of hash values independent of the number, length and type of input values.  
It also has a good Avalanche Effect property: even a minimal differences (1 bit) of input values produces very different hash values.  

#### java.lang.String.hashCode(): suboptimal dispersion 
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/java_hash.png)<br>
**Hash funtion**: java.lang.String.hashCode()     
**Source file**: words_en.txt    
**Distinct words**: 65503    
**Data length** = 262012 bytes   
**Average byte frequency μ** = 1023.48    
**Minimum byte frequency** = 797    
**Maximum byte frequency** = 8727    
**Variance σ<sup>2</sup>** = 282898.28   
**Standard Deviation σ** = 531.88  
**Coefficient of Variation <sup>σ</sup>/<sub>μ</sub>** = 51.97%   
**Chi-Square Test 𝛘<sup>2</sup>** = 70760.20   
**Average bytes value** = 120.73 (127.5 random)   
**Entropy** = 7.9119 bits (8 random)    
**Monte Carlo for π 2D** = 3.210497 (error = 2.193%)   
**Monte Carlo for π 3D** = 3.360676 (error = 6.974%)    
**Average of Contiguous Byte Pairs** = 31027.8356 (32767.5 random) (error 5.309%)    
**4 Bytes Collisions** = 118 (expected collisions = 0.4995)    

#### mzHash32(): optimal dispersion
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/mzh32_distributions.png)<br>
**Hash funtion**: mzHash32()     
**Source file**: words_en.txt       
**Distinct words**: 65503       
**Data length** = 262012 bytes    
**Average byte frequency μ** = 1023.48    
**Minimum byte frequency** = 932   
**Maximum byte frequency** = 1103    
**Variance σ<sup>2</sup>** = 1008.16    
**Standard Deviation σ** = 31.75    
**Coefficient of Variation <sup>σ</sup>/<sub>μ</sub>** = 3.10%    
**Chi-Square Test 𝛘<sup>2</sup>** = 252.17   
**Average bytes value** = 127.63 (127.5 random)   
**Entropy** = 7.9993 bits (8 random)     
**Monte Carlo for π 2D** = 3.14079 (error = 0.026%)    
**Monte Carlo for π 3D** = 3.14324 (error = 0.052%)    
**Average of Contiguous Byte Pairs** = 32801.42 (32767.5 random) (error 0.10%)     
**4 Bytes Collisions** = 0 (expected collisions = 0.4995)     

## Collision numbers close to expected value
mzHash32 produces a very low number of collisions for each reasonably large number of distinct values; it is close to the collisions number of a Universal Hash Function.  
The number is given by the formula _n-m*(1-((m-1)/m)^n)_ where _n_ is the number of input values, _m_ is the number of all possible hash values (2^32 or 2^64).  

#### Number of collisions for string inputs

Data input                                         |   #Vaues    |#Expected Collisions|  mzHash32 | Murmur3 |     XX
:---                                               |         ---:|                ---:|       ---:|     ---:|    ---:
File words_en.txt                                  |      65,503 |         0.5        |          0|        0|       0
File words_es.txt                                  |      74,571 |         0.6        |          1|        2|       0
File words_latin.txt                               |      80,007 |         0.7        |          0|        1|       1
File words_it.txt                                  |     117,558 |         1.6        |          3|        0|       2
File words_en_es_it_latin.txt                      |     315,198 |        11.6        |         13|        9|       9
File words_and_numbers.txt                         |     429,187 |        21.4        |         19|       20|      19
File first_million_primes.txt                      |   1,000,000 |       116.4        |        118|      118|  **85**
File random_64_signed_nums.txt                     |   1,000,000 |       116.4        |        115|      110|  **143**
Numbers in english from **"zero"** to **"nine million nine hundred ninety-nine thousand nine hundred ninety-nine"**|10,000,000| 11,633 | 11,599| 11,672 | 11,474
File [rockyou.txt](https://github.com/brannondorsey/naive-hashcat/releases/download/data/rockyou.txt) dictionary of common passwords|14,344,391|23,927|23,990|24,206|23,895
Numbers in english from **"five hundred thirty-nine billion four hundred ten million seven hundred one thousand four hundred eighty-three"** to **"five hundred thirty-nine billion four hundred twenty million seven hundred one thousand four hundred eighty-two"** | 10,000,000 | 11,633 | 11,588 | 11,612 | 11,539
Number as strings from<br>"1234567890123456789" to "1234567890223456788" | 100,000,000 | 1,155,171 | 1,153,524 | 1,155,789|   **808,693**
Strings from<br>"abcdefg1234567890<br>123456789hijklmn" to "abcdefg1234567890<br>223456788hijklmn" | 100,000,000 | 1,155,171| 1,160,384 | 1,152,600| **1,037,151** 
Numbers as strings from "0" to "999999"                |1,000,000| 116.4 |114|120|**17**
Numbers as strings from "aaaa0aaaa" to "aaaa999999aaaa"|1,000,000| 116.4 |114|112|**22**
Hex numbers as string from "0" to "98967F"| 10,000,000| 11,633| 10,772|11,433|**2,537**

#### Number of collisions for binary inputs
Data input                                         |   #Vaues    |#Expected Collisions|  mzHash32 | Murmur3 |   XX
:---                                               |         ---:|                ---:|       ---:|     ---:|  ---:
Binary 32 bytes random                             |  1,000,000  |             116.4  |     133   |   121   |   127 
Binary 40 bytes [b,b,b,b,b,b,b,b,b,b] b from FF676980 to FFFFFFFF| 10,000,000|11,633|11,539| 11,695| 11,846
Binary 24 bytes [b,b,b,b,b,b], b from 00000000 to 0098967F|10,000,000| 11,633| 11,531 | 11,509| **1,542**
Binary 24 bytes [b,b\*3,b\*5,b\*7,b\*11,b\*13], b from 00000000 to 0098967F|10,000,000| 11,633| 11,564 | 11,664| 10,831

Note that the number of collisions of mzHash32 is always very close to the expected value; the same goes for murmur3, while XX sometimes deviates significantly from the expected value (outliers in bold).

## Evaluating seed sensitivity
A good non-cryptographic hash function should be robust with respect to the seed: its behavior (especially the number of collisions) shouldn't change significantly with variations in the seed.   
This ensures stable performance, predictability, and a uniform distribution of hash values.   
MzHash32 maintains statistical characteristics regardless of the choice of seed; the number of collisions can vary, but always within a range that ensures a uniform distribution of the output. Furthermore, the choice of seed does not affect performance.    
If there are no specific needs, it is recommended to use mzHash32 with the default seed (0) as it is optimized to produce the closest possible number of collisions to the theoretically expected number, but in case of need the quality of mzHash32 remains extremely high with the choice of a different seed.  

#### Analisys of the impact of seed choice (10,000 tests with random seed)

**Data input**: Numbers in english from "zero" to "nine hundred ninety-nine thousand nine hundred ninety-nine"  
**Values**: 1,000,000  
##### Distribution of hash values
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/mzhash32_seed_map.png).

## Speed
MzHash32 processes byte by byte, while Murmur and XX group 4 bytes at a time for each processing. Therefore, the speed of MzHash32 is lower, however, if the execution speed of MzHash32 is compared with other functions that process one byte at a time, it is very high-performance since the number of operations performed in each cycle is really low. The comparison obviously must be made with functions that guarantee an optimal number of collisions, close to a Universal Hash Function  
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/mzhash32speed.png)

## Vulnerability
MzHash32, like most non-cryptographic functions, is non-secure because it is not specifically designed to be difficult to reverse by an adversary, making it unsuitable for cryptographic purposes. Its use is instead recommended in all other contexts where hash functions are used.   

## Portability
It is minimalist, elegant, straightforward and can be easily written in virtually any programming language. 
It produces the same result with x86 and x64 (or different) platforms.
Currently C and Java versions are available.

## Conclusion
MzHash32 demonstrates to have an excellet quality of the dispersion, close to an ideal Universal Hash Function. It is simple, portable and produces same results in all platform (x86 and x64). On the other hand it is slower than XX and Murmur3. If the goal is the quality of the dispersion and have the same result on x86 and x64 platforms, mzHash32 is certainly the function to choose!
