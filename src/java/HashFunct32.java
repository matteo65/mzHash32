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

	public static int mzHash32(byte[] data, int start, int length, int seed) {	
		int hash = 0x8979BEFC ^ seed;
		
		for(int i = 0; i < length; i++)
			hash = 0x99AF844D * ((i + data[start + i]) ^ (hash << 2) ^ (hash >>> 2));
		
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
		int hash = 0x8979BEFC ^ seed;
		
		return 0x99AF844D * (b ^ (hash << 2) ^ (hash >>> 2));
	}

	public static int mzHash32(byte b) {
		return 0x99AF844D * (b ^ 0x07B8944F);
	}

	public static int mzHash32(short s, int seed) {
		int hash = 0x8979BEFC ^ seed;
		
		hash = 0x99AF844D * ((byte)s ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((1 + (byte)(s >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(short s) {
		int hash = 0x99AF844D * ((byte)s ^ 0x07B8944F);
		
		hash = 0x99AF844D * ((1 + (byte)(s >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(int i, int seed) {
		int hash = 0x8979BEFC ^ seed;
		
		hash = 0x99AF844D * ((byte)i ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((1 + (byte)(i >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((2 + (byte)(i >> 16)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((3 + (byte)(i >> 24)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(int i) {
		int hash = 0x99AF844D * ((byte)i ^ 0x07B8944F);
		
		hash = 0x99AF844D * ((1 + (byte)(i >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((2 + (byte)(i >> 16)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((3 + (byte)(i >> 24)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(long l, int seed) {
		int hash = 0x8979BEFC ^ seed;
		
		hash = 0x99AF844D * ((byte)l ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((1 + (byte)(l >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((2 + (byte)(l >> 16)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((3 + (byte)(l >> 24)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((4 + (byte)(l >> 32)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((5 + (byte)(l >> 40)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((6 + (byte)(l >> 48)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((7 + (byte)(l >> 56)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(long l) {
		int hash = 0x99AF844D * ((byte)l ^ 0x07B8944F);
		
		hash = 0x99AF844D * ((1 + (byte)(l >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((2 + (byte)(l >> 16)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((3 + (byte)(l >> 24)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((4 + (byte)(l >> 32)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((5 + (byte)(l >> 40)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((6 + (byte)(l >> 48)) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((7 + (byte)(l >> 56)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(char c, int seed) {
		int hash = 0x8979BEFC ^ seed;
		
		hash = 0x99AF844D * ((byte)c ^ (hash << 2) ^ (hash >>> 2));
		hash = 0x99AF844D * ((1 + (byte)(c >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static int mzHash32(char c) {
		int hash = 0x99AF844D * ((byte)c ^ 0x07B8944F);
		
		hash = 0x99AF844D * ((1 + (byte)(c >> 8)) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
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
		return b ? 0x869730EF : 0x91C11A5F;
	}

}
