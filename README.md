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

#### 32-bit: number of collisions for ASCII strings

Data input                                         |   #Vaues    |#Expected Collisions|    mzHash     |   Murmur3     |     XX
:---                                               |         ---:|                ---:|           ---:|           ---:|    ---:
Numbers as strings from "0" to "999999999"         |1,000,000,000| 107,882,641        |**107,869,763**|**107,822,463**|110,287,893
File words_en.txt                                  |    65,503   |         0          |          **0**|          **0**|      **0**
File words_es.txt                                  |    74,571   |         0          |          **0**|              2|      **0**
File words_it.txt                                  |   117,558   |         1          |          **0**|          **0**|        2
File words_latin.txt                               |    80,007   |         0          |          **0**|              1|        1
File words_en_es_it_latin.txt                      |   315,198   |        11          |          **8**|          **9**|      **9**
File words_and_numbers.txt                         |   429,187   |        21          |         **14**|             20|     **19**
File first_million_primes.txt                      |   1,000,000 |       116          |        **101**|            118|     **85**
File random_64bit_signed_numbers.txt               |   1,000,000 |       116          |        **101**|        **110**|      143
