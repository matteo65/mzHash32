/**
 * mzhash32
 * 
 * Strong, fast, simple, non-cryptographic 32-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2025-06
 * Reelease: 3
 *
 * SPDX-FileCopyrightText: 2025 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */
public class HashFunct32 {

	private HashFunct32() {}

	public static final int mzHash32(byte[] data, int start, int length, int seed) {
		int hash = 0x06EAFDF7 ^ seed;

		for(int i = 0; i < length; i++)
			hash = 0x7554DEEB * (data[start + i] ^ hash ^ (hash << 2) ^ (hash >>> 2));
				
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
		int hash = 0x06EAFDF7 ^ seed;
		
		return 0x7554DEEB * (b ^ hash ^ (hash << 2) ^ (hash >>> 2));
	}

	public static final int mzHash32(byte b) {
		return 0x7554DEEB * (b ^ 0x1CFBB556);
	}

	public static final int mzHash32(short s, int seed) {
		int hash = 0x06EAFDF7 ^ seed;
		
		hash = 0x7554DEEB * ((byte)s        ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(s >> 8) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(short s) {
		int hash = 0x7554DEEB * ((byte)s ^ 0x1CFBB556);
		
		hash = 0x7554DEEB * ((byte)(s >> 8) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(int i, int seed) {
		int hash = 0x06EAFDF7 ^ seed;
		
		hash = 0x7554DEEB * ((byte)i         ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(i >> 8)  ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(i >> 16) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(i >> 24) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(int i) {
		int hash = 0x7554DEEB * ((byte)i ^ 0x1CFBB556);
		
		hash = 0x7554DEEB * ((byte)(i >> 8)  ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(i >> 16) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(i >> 24) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(long l, int seed) {
		int hash = 0x06EAFDF7 ^ seed;
		
		hash = 0x7554DEEB * ((byte)l         ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 8)  ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 16) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 24) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 32) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 40) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 48) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(l >> 56) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(long l) {
	    int hash = 0x7554DEEB * ((byte)l ^ 0x1CFBB556);
		
	    hash = 0x7554DEEB * ((byte)(l >> 8)  ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0x7554DEEB * ((byte)(l >> 16) ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0x7554DEEB * ((byte)(l >> 24) ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0x7554DEEB * ((byte)(l >> 32) ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0x7554DEEB * ((byte)(l >> 40) ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0x7554DEEB * ((byte)(l >> 48) ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0x7554DEEB * ((byte)(l >> 56) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(char c, int seed) {
		int hash = 0x06EAFDF7 ^ seed;
		
		hash = 0x7554DEEB * ((byte)c        ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x7554DEEB * ((byte)(c >> 8) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static final int mzHash32(char c) {
		int hash = 0x7554DEEB * ((byte)c ^ 0x1CFBB556);
		
		hash = 0x7554DEEB * (hash ^ (byte)(c >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
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
		return b ? 0x1F8D82E8 : 0x40905DEB;
	}
	
}

