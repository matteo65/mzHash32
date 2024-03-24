/**
 * mzHash32
 * 
 * Strong, fast, simple, non-cryptographic 32-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2022
 * Licence: Public Domain
 * 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <https://unlicense.org>
 * 
 */
public class HashFunct32 {
	
	public static int mzHash32(byte[] data, int start, int length, int seed) {	
		int hash = 0x95DE1432 ^ seed;
		
		for(int i = 0; i < length; i++)
			hash = 0xA8657C5B * (i + data[start + i]) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static int mzHash32(byte[] data, int start, int length) {
		return mzHash32(data, start, length, 0);
	}
	
	public static int mzHash32(byte[] data) {
		return mzHash32(data, 0, data.length, 0);
	}
	
	public static int mzHash32(byte[] data, int seed) {	
		return mzHash32(data, 0, data.length, seed);
	}

	public static int mzHash32(byte b, int seed) {
		int hash = 0x95DE1432 ^ seed;
		return 0xA8657C5B * b ^ (hash << 2) ^ (hash >>> 2);
	}
	
	public static int mzHash32(byte b) {
		return 0xA8657C5B * b ^ 0x720FD5C4;
	}
	
	public static int mzHash32(short s, int seed) {
		int hash = 0x95DE1432 ^ seed;
		
		hash = 0xA8657C5B * (byte)s ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (1 + (byte)(s >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static int mzHash32(short s) {
		return mzHash32(s, 0);
	}
	
	public static int mzHash32(int i, int seed) {
		int hash = 0x95DE1432 ^ seed;
		
		hash = 0xA8657C5B * (byte)i ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (1 + (byte)(i >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (2 + (byte)(i >> 16)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (3 + (byte)(i >> 24)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static int mzHash32(int i) {
		return mzHash32(i, 0);
	}
	
	public static int mzHash32(long l, int seed) {
		int hash = 0x95DE1432 ^ seed;
		
		hash = 0xA8657C5B * (byte)l ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (1 + (byte)(l >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (2 + (byte)(l >> 16)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (3 + (byte)(l >> 24)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (4 + (byte)(l >> 32)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (5 + (byte)(l >> 40)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (6 + (byte)(l >> 48)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (7 + (byte)(l >> 56)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static int mzHash32(long l) {
		return mzHash32(l, 0);
	}
	
	public static int mzHash32(char c, int seed) {
		int hash = 0x95DE1432 ^ seed;
		
		hash = 0xA8657C5B * (byte)c ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xA8657C5B * (1 + (byte)(c >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static int mzHash32(char c) {
		return mzHash32(c, 0);
	}
	
	public static int mzHash32(String str, int seed) {
		return mzHash32(str.getBytes(), seed);
	}
	
	public static int mzHash32(String str) {
		return mzHash32(str.getBytes(), 0);
	}
	
	public static int mzHash32(boolean b, int seed) {
		return b ? mzHash32(1, seed) : mzHash32(0, seed);
	}
	
	public static int mzHash32(boolean b) {
		return b ? 0x140B7AE0 : 0x247957A5;
	}
	
}

