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
