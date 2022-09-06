# mzHash32
Strong, fast, simple non-cryptography function

```java
public static int mzHash32(final byte[] data, int pos, int length, int seed) {
	int hash = seed;
	for(int i = 0; i < length; i++)
		hash = (-2073894052 * (i + data[pos + i]))  ^ (h << 2) ^ (h >>> 2);
	return hash;
}

public static int mzHash32(final byte[] data, int pos, int length) {
  return mzHash32(data, pos, length, 0);
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
