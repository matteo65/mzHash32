# mzHash32
Strong, fast, simple non-cryptography function

```java
public static int mzHash32(final byte[] data, int pos, int length) {
	int hash = 0;
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

#### Number of collisions for strings as input

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
Number as strings from "1234567890123456789" to "1234567890223456788" | 100,000,000 | 1,155,171 | **1,154,640** | 1,155,789|   **808,693**
Strings from "abcdefg1234567890123456789hijklmn" to "abcdefg1234567890223456788hijklmn" | 100,000,000 | 1,155,171| **1,125,889** | **1,152,600**| **1,037,151** 
Numbers as strings from "0" to "999999999"         |1,000,000,000| 107,882,641        |**107,105,249**|**107,822,463**|110,287,893
Numbers as strings from "aaaa0aaaa" to "aaaa1999999999aaaa"|2,000,000,000| 401,068,994 |**400,972,197**|**401,043,716**|**391,119,332**
Hex numbers as string from "0" to "7FFFFFFE"| 2,147,483,647| 457,545,699| **457,447,653**|**457,465,265**|460,825,702

#### Number of collisions for binary inputs
Data input                                         |   #Vaues    |#Expected Collisions|    mzHash     |   Murmur3     |     XX
:---                                               |         ---:|                ---:|           ---:|           ---:|    ---:
Binary 24 bytes [b,b,b,b,b,b], b from 00000000 to 05F5E0FF|100,000,000| 1,155,171| **1,155,140** | **1,154,653**| 1,411,483

## Vulnerability
mzHash32, like most non-cryptographic functions, is non-secure because it is not specifically designed to be difficult to reverse by an adversary, making it unsuitable for cryptographic purposes. Its use is instead recommended in all other contexts where hash functions are used.  
Like other non-cryptographic functions, its security depends on the secrecy of the possibly used seed.  


## Portability
It is minimalist, elegant, straightforward and can be easily written in virtually any programming language. 
It produces the same result with x86 and x64 (or different) platforms.
Currently C and Java versions are available.  
