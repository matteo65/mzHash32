# mzHash32
Strong, fast, simple, non-cryptography hash function

```java
public static int mzHash32(final byte[] data, int start, int length, int seed) {
	int hash = seed;
	for(int i = 0; i < length; i++)
		hash = 0xEC76399C * (0x76BD2B1E + i + data[start + i]) ^ (hash << 2) ^ (hash >>> 2);
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
**Average byte frequency** = 1023.48    
**Minimum byte frequency** = 797    
**Maximum byte frequency** = 8727    
**Variance** = 282898.28   
**Standard Deviation** = 531.88  
**Coefficient of Variation** = 51.97%   
**Chi-Square Test** = 70760.20   
**Average bytes value** = 120.73 (127.5 random)   
**Entropy** = 7.9119 bits (8 random)    
**Monte Carlo for Pi 2D** = 3.210497 (error = 2.193%)   
**Monte Carlo for Pi 3D** = 3.360676 (error = 6.974%)    
**Average of Contiguous Byte Pairs** = 31027.8356 (32767.5 random) (error 5.309%)    
**4 Bytes Collisions** = 118 (expected collisions = 0.4994)    

#### mzHash32(): optimal dispersion
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/mzh32_distributions.png)<br>
**Hash funtion**: mzHash32()     
**Source file**: words_en.txt       
**Distinct words**: 65503       
**Data length** = 262012 bytes    
**Average byte frequency** = 1023.48    
**Minimum byte frequency** = 931   
**Maximum byte frequency** = 1104    
**Variance** = 1022.09    
**Standard Deviation** = 31.97    
**Coefficient of Variation** = 3.12%    
**Chi-Square Test** = 255.65   
**Average bytes value** = 127.26 (127.5 random)   
**Entropy** = 7.9993 bits (8 random)     
**Monte Carlo for Pi 2D** = 3.147202 (error = 0.1785%)    
**Monte Carlo for Pi 3D** = 3.155606 (error = 0.4460%)    
**Average of Contiguous Byte Pairs** = 32705.0919 (32767.5 random) (error 0.190%)     
**4 Bytes Collisions** = 0 (expected collisions = 0.4994)     


## Collision numbers close to expected value
mzHash32 produces a very low number of collisions for each reasonably large number of distinct values; it is close to the collisions number of a Universal Hash Function.  
The number is given by the formula _n-m*(1-((m-1)/m)^n)_ where _n_ is the number of input values, _m_ is the number of all possible hash values (2^32 or 2^64).  

#### Number of collisions for string inputs

Data input                                         |   #Vaues    |#Expected Collisions|  mzHash32 | Murmur3 |     XX
:---                                               |         ---:|                ---:|       ---:|     ---:|    ---:
File words_en.txt                                  |      65,503 |         0.5        |          0|        0|       0
File words_es.txt                                  |      74,571 |         0.6        |          1|        2|       0
File words_latin.txt                               |      80,007 |         0.7        |          1|        1|       1
File words_it.txt                                  |     117,558 |         1.6        |          1|        0|       2
File words_en_es_it_latin.txt                      |     315,198 |        11.6        |         13|        9|       9
File words_and_numbers.txt                         |     429,187 |        21.4        |         23|       20|      19
File first_million_primes.txt                      |   1,000,000 |       116.4        |        113|      118|  **85**
File random_64_signed_nums.txt                     |   1,000,000 |       116.4        |        119|      110|  **143**
Numbers in english from **"zero"** to **"nine million nine hundred ninety-nine thousand nine hundred ninety-nine"**|10,000,000| 11,633 | 11,502 | 11,672 | 11,474
File [rockyou.txt](https://github.com/brannondorsey/naive-hashcat/releases/download/data/rockyou.txt) dictionary of common passwords|14,344,391|23,927|23,913|24,206|23,895
Numbers in english from **"five hundred thirty-nine billion three hundred twenty million seven hundred one thousand four hundred eighty-three"** to **"five hundred thirty-nine billion four hundred twenty million seven hundred one thousand four hundred eighty-two"** | 100,000,000 | 1,155,171 | 1,154,946 | 1,155,029 | 1,154,135
Number as strings from<br>"1234567890123456789" to "1234567890223456788" | 100,000,000 | 1,155,171 | 1,195,229 | 1,155,789|   **808,693**
Strings from<br>"abcdefg1234567890<br>123456789hijklmn" to "abcdefg1234567890<br>223456788hijklmn" | 100,000,000 | 1,155,171| 1,138,092 | 1,152,600| **1,037,151** 
Numbers as strings from "0" to "999999999"         |1,000,000,000| 107,882,641        |108,150,889|107,822,463|110,287,893
Numbers as strings from "aaaa0aaaa" to "aaaa1999999999aaaa"|2,000,000,000| 401,068,994 |399,922,661|401,043,716|391,119,332
Hex numbers as string from "0" to "7FFFFFFE"| 2,147,483,647| 457,545,699| 456,687,411|457,465,265|460,825,702

#### Number of collisions for binary inputs
Data input                                         |   #Vaues    |#Expected Collisions|  mzHash32 | Murmur3 |   XX
:---                                               |         ---:|                ---:|       ---:|     ---:|  ---:
Binary 32 bytes random                             |    100,000  |             1.164  |     2     |   0     |    2 
Binary 40 bytes [b,b,b,b,b,b,b,b,b,b] b from FF676980 to FFFFFFFF| 10,000,000|11,633|11,676| 11,695| 11,846
Binary 24 bytes [b,b,b,b,b,b], b from 00000000 to 05F5E0FF|100,000,000| 1,155,171| 1,157,305 | 1,154,653| **1,411,483**
Binary 24 bytes [b,b\*3,b\*5,b\*7,b\*11,b\*13], b from 00000000 to 05F5E0FF|100,000,000| 1,155,171| 1,154,367 | 1,154,542| 1,160,003
Binary 24 bytes [b,b,b,b,b,b], b from 00000000 to 05F5E0FF|1,000,000,000| 107,882,641| 107,904,990 | 107,880,319| **113,834,210**

Note that the number of collisions of mzHash32 is always very close to the expected value; the same goes for murmur3, while XX sometimes deviates significantly from the expected value (outliers in bold).

## Evaluating seed sensitivity
A good non-cryptographic hash function should be robust with respect to the seed: its behavior (especially the number of collisions) shouldn't change significantly with variations in the seed.   
This ensures stable performance, predictability, and a uniform distribution of hash values.   
MzHash32 maintains statistical characteristics regardless of the choice of seed; the number of collisions can vary, but always within a range that ensures a uniform distribution of the output. Furthermore, the choice of seed does not affect performance.  
If there are no specific needs, it is recommended to use mzHash32 with the default seed (0) as it is optimized to produce the closest possible number of collisions to the theoretically expected number, but in case of need the quality of mzHash32 remains extremely high with the choice of a different seed.  

#### Analisys of the impact of seed choice

## Speed
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/mzhash32speed.jpg)

## Vulnerability
MzHash32, like most non-cryptographic functions, is non-secure because it is not specifically designed to be difficult to reverse by an adversary, making it unsuitable for cryptographic purposes. Its use is instead recommended in all other contexts where hash functions are used.  
Like other non-cryptographic functions, its security depends on the secrecy of the possibly used seed.  

## Portability
It is minimalist, elegant, straightforward and can be easily written in virtually any programming language. 
It produces the same result with x86 and x64 (or different) platforms.
Currently C and Java versions are available.

## Conclusion
MzHash32 demonstrates to have an excellet quality of the dispersion, close to an ideal Universal Hash Function. It is simple, portable and produces same results in all platform (x86 and x64). On the other hand it is slower than XX and Murmur3. If the goal is the quality of the dispersion and have the same result on x86 and x64 platforms, mzHash32 is certainly the function to choose!
