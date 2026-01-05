/**
 * mzhash32
 * 
 * Strong, fast, simple, non-cryptographic 32-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2026-01
 * Reelease: 5
 *
 * SPDX-FileCopyrightText: 2026 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */
public final class HashFunct32 {

	private HashFunct32() {}

	public static final int mzHash32(byte[] data, int start, int length, int seed) {
		int hash = 0x514430D1 | seed;

		for(int i = 0; i < length; i++)
			hash = 0x003C50DB * (data[start + i] ^ (hash << 1) ^ (hash >>> 1));
				
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
		int hash = 0x514430D1 | seed;
		
		return 0x003C50DB * (b ^ (hash << 1) ^ (hash >>> 1));
	}

	public static final int mzHash32(byte b) {
		return 0x003C50DB * (b ^ 0x8A2A79CA);
	}

	public static final int mzHash32(short s, int seed) {
		int hash = 0x514430D1 | seed;
		
		hash = 0x003C50DB * ((byte)s        ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(s >> 8) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(short s) {
		int hash = 0x003C50DB * ((byte)s ^ 0x8A2A79CA);
		
		hash = 0x003C50DB * ((byte)(s >> 8) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(int i, int seed) {
		int hash = 0x514430D1 | seed;
		
		hash = 0x003C50DB * ((byte)i         ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(i >> 8)  ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(i >> 16) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(i >> 24) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(int i) {
		int hash = 0x003C50DB * ((byte)i ^ 0x8A2A79CA);
		
		hash = 0x003C50DB * ((byte)(i >> 8)  ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(i >> 16) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(i >> 24) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(long l, int seed) {
		int hash = 0x514430D1 | seed;
		
		hash = 0x003C50DB * ((byte)l         ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 8)  ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 16) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 24) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 32) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 40) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 48) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(l >> 56) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(long l) {
	    int hash = 0x003C50DB * ((byte)l ^ 0x8A2A79CA);
		
	    hash = 0x003C50DB * ((byte)(l >> 8)  ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x003C50DB * ((byte)(l >> 16) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x003C50DB * ((byte)(l >> 24) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x003C50DB * ((byte)(l >> 32) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x003C50DB * ((byte)(l >> 40) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x003C50DB * ((byte)(l >> 48) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x003C50DB * ((byte)(l >> 56) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(char c, int seed) {
		int hash = 0x514430D1 | seed;
		
		hash = 0x003C50DB * ((byte)c        ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x003C50DB * ((byte)(c >> 8) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static final int mzHash32(char c) {
		int hash = 0x003C50DB * ((byte)c ^ 0x8A2A79CA);
		
		hash = 0x003C50DB * ((byte)(c >> 8) ^ (hash << 1) ^ (hash >>> 1));
		
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
		return b ? 0x33E32857 : 0xF06DF603;
	}

}




