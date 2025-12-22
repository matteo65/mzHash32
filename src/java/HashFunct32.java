/**
 * mzhash32
 * 
 * Strong, fast, simple, non-cryptographic 32-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2025-12
 * Reelease: 4
 *
 * SPDX-FileCopyrightText: 2025 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */
public class HashFunct32 {

	private HashFunct32() {}

	public static final int mzHash32(byte[] data, int start, int length, int seed) {
		int hash = 0x032559B1 ^ seed;

		for(int i = 0; i < length; i++)
			hash = 0xCF4EDCBF * (data[start + i] ^ (hash << 2) ^ (hash >>> 2));
				
		return hash;
	}

	public static final int mzHash32(byte[] data, int start, int length) {
		return mzHash32(data, start, length, 0);
	}

	public static final int mzHash32(byte[] data) {
		return mzHash32(data, 0, data.length, 0);
	}

	public static final int mzHash32(byte[] data, int seed) {	
		return mzHash32(data, 0, data.length, seed);
	}

	public static final int mzHash32(byte b, int seed) {
		int hash = 0x032559B1 ^ seed;
		
		return 0xCF4EDCBF * (b ^ (hash << 2) ^ (hash >>> 2));
	}

	public static final int mzHash32(byte b) {
		return 0xCF4EDCBF * (b ^ 0x0C5C30A8);
	}

	public static final int mzHash32(short s, int seed) {
		int hash = 0x032559B1 ^ seed;
		
		hash = 0xCF4EDCBF * ((byte)s        ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(s >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(short s) {
		int hash = 0xCF4EDCBF * ((byte)s ^ 0x0C5C30A8);
		
		hash = 0xCF4EDCBF * ((byte)(s >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(int i, int seed) {
		int hash = 0x032559B1 ^ seed;
		
		hash = 0xCF4EDCBF * ((byte)i         ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(i >> 8)  ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(i >> 16) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(i >> 24) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(int i) {
		int hash = 0xCF4EDCBF * ((byte)i ^ 0x0C5C30A8);
		
		hash = 0xCF4EDCBF * ((byte)(i >> 8)  ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(i >> 16) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(i >> 24) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(long l, int seed) {
		int hash = 0x032559B1 ^ seed;
		
		hash = 0xCF4EDCBF * ((byte)l         ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 8)  ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 16) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 24) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 32) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 40) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 48) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(l >> 56) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(long l) {
	    int hash = 0xCF4EDCBF * ((byte)l ^ 0x0C5C30A8);
		
	    hash = 0xCF4EDCBF * ((byte)(l >> 8)  ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCF4EDCBF * ((byte)(l >> 16) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCF4EDCBF * ((byte)(l >> 24) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCF4EDCBF * ((byte)(l >> 32) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCF4EDCBF * ((byte)(l >> 40) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCF4EDCBF * ((byte)(l >> 48) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCF4EDCBF * ((byte)(l >> 56) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(char c, int seed) {
		int hash = 0x032559B1 ^ seed;
		
		hash = 0xCF4EDCBF * ((byte)c        ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCF4EDCBF * ((byte)(c >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(char c) {
		int hash = 0xCF4EDCBF * ((byte)c ^ 0x0C5C30A8);
		
		hash = 0xCF4EDCBF * ((byte)(c >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(String str, int seed) {
		return mzHash32(str.getBytes(), seed);
	}

	public static final int mzHash32(String str) {
		return mzHash32(str.getBytes(), 0);
	}

	public static final int mzHash32(boolean b, int seed) {
		return b ? mzHash32(1, seed) : mzHash32(0, seed);
	}

	public static final int mzHash32(boolean b) {
		return b ? 0x5B936D06 : 0x2E45E657;
	}
	
}




