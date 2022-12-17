# mzHash32
Strong, fast, simple non-cryptography hash function

```java
public static int mzHash32(final byte[] data, int pos, int length, int seed) {
	int hash = 0x95DE1432 ^ seed;
	for(int i = 0; i < length; i++)
		hash = (0xA8657C5B * (i + data[pos + i])) ^ (h << 2) ^ (h >>> 2);
	return hash;
}
```
## Uniform distribution of hash values (diffusion)
It has an absolutely uniform, chaotic distribution of hash values independent of the number, length and type of input values.  
It also has a good Avalanche Effect property: even a minimal differences (1 bit) of input values produces very different hash values.  

#### java.util.Arrays.hashCode()
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/java_hash.png)
  
#### mzHash32()
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash32/main/Resource/mzh32_distributions.png)

## Minimum number of collisions
mzHash32 produces a very low number of collisions for each reasonably large number of distinct values; it is close to the collisions number of a Universal Hash Function.  
The number is given by the formula _n-m*(1-((m-1)/m)^n)_ where _n_ is the number of input values, _m_ is the number of all possible hash values (2^32 or 2^64).  

#### Number of collisions for string inputs

Data input                                         |   #Vaues    |#Expected Collisions|    mzHash     |   Murmur3     |     XX
:---                                               |         ---:|                ---:|           ---:|           ---:|    ---:
File words_en.txt                                  |      65,503 |         0          |          **0**|          **0**|      **0**
File words_es.txt                                  |      74,571 |         1          |          **0**|              2|      **0**
File words_latin.txt                               |      80,007 |         1          |          **1**|          **1**|      **1**
File words_it.txt                                  |     117,558 |         2          |          **0**|          **0**|      **2**
File words_en_es_it_latin.txt                      |     315,198 |        12          |          **9**|          **9**|      **9**
File words_and_numbers.txt                         |     429,187 |        21          |         **17**|         **20**|     **19**
File first_million_primes.txt                      |   1,000,000 |       116          |        **109**|            118|     **85**
File random_64bit_signed_numbers.txt               |   1,000,000 |       116          |        **105**|        **110**|      143
Numbers in english from "zero" to "nine million nine hundred ninety-nine thousand nine hundred ninety-nine"|10,000,000| 11,633 | 11,735 | 11,672 | **11,474**
Numbers in english from "five hundred thirty-nine billion three hundred twenty million seven hundred one thousand four hundred eighty-three" to "five hundred thirty-nine billion four hundred twenty million seven hundred one thousand four hundred eighty-two" | 100,000,000 | 1,155,171 | **1,152,258** | **1,155,029** | **1,154,135**
Number as strings from<br>"1234567890123456789" to "1234567890223456788" | 100,000,000 | 1,155,171 | **1,154,640** | 1,155,789|   **808,693**
Strings from "abcdefg1234567890<br>123456789hijklmn" to "abcdefg1234567890<br>223456788hijklmn" | 100,000,000 | 1,155,171| **1,125,889** | **1,152,600**| **1,037,151** 
Numbers as strings from "0" to "999999999"         |1,000,000,000| 107,882,641        |**107,105,249**|**107,822,463**|110,287,893
Numbers as strings from "aaaa0aaaa" to "aaaa1999999999aaaa"|2,000,000,000| 401,068,994 |**400,972,197**|**401,043,716**|**391,119,332**
Hex numbers as string from "0" to "7FFFFFFE"| 2,147,483,647| 457,545,699| **457,447,653**|**457,465,265**|460,825,702

#### Number of collisions for binary inputs
Data input                                         |   #Vaues    |#Expected Collisions|    mzHash     |   Murmur3     |     XX
:---                                               |         ---:|                ---:|           ---:|           ---:|    ---:
Binary 32 bytes random                             |    100,000  |                 1  |     **1**     |   **0**       |    2 
Binary 40 bytes [b,b,b,b,b,b,b,b,b,b] b from FF676980 to FFFFFFFF| 10,000,000|11,633|**11,295**| 11,695| 11,846
Binary 24 bytes [b,b,b,b,b,b], b from 00000000 to 05F5E0FF|100,000,000| 1,155,171| **1,155,140** | **1,154,653**| 1,411,483
Binary 24 bytes [b,b\*3,b\*5,b\*7,b\*11,b\*13], b from 00000000 to 05F5E0FF|100,000,000| 1,155,171| **1,154,633** | **1,154,542**| 1,160,003
Binary 24 bytes [b,b,b,b,b,b], b from 00000000 to 05F5E0FF|1,000,000,000| 107,882,641| 107,908,082 | **107,880,319**| 113,834,210

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
