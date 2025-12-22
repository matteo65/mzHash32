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

	private HashFunct64() {}

    public static long mzHash64(byte[] data, int start, int length, long seed) {    
        long hash = 0xDED46DB8C47B7480L ^ seed;
        
        for(int i = 0; i < length; i++)
            hash = 0xE958AC98E3D243C3L * (data[start + i] ^ (hash << 2) ^ (hash >>> 2));
        
        return hash;
    }

	public static long mzHash64(byte[] data, int start, int length) {
		return mzHash64(data, start, length, 0);
	}

	public static long mzHash64(byte[] data) {
		return mzHash64(data, 0, data.length, 0);
	}

	public static long mzHash64(byte[] data, long seed) {	
		return mzHash64(data, 0, data.length, seed);
	}

	public static long mzHash64(byte b, long seed) {
		long hash = 0xDED46DB8C47B7480L ^ seed;
		return 0xE958AC98E3D243C3L * (b ^ (hash << 2) ^ (hash >>> 2));
	}

	public static long mzHash64(byte b) {
		return 0xE958AC98E3D243C3L * (b ^ 0x4CE4AD8D20F30F20L);
	}

	public static long mzHash64(short s, long seed) {
	    long hash = 0xDED46DB8C47B7480L ^ seed;
		
		hash = 0xE958AC98E3D243C3L * ((byte)s        ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(s >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(short s) {   
        long hash = 0xE958AC98E3D243C3L * ((byte)s ^ 0x4CE4AD8D20F30F20L);
        hash = 0xE958AC98E3D243C3L * ((byte)(s >> 8) ^ (hash << 2) ^ (hash >>> 2));
        
        return hash;
	}

	public static long mzHash64(int i, long seed) {
		long hash = 0xDED46DB8C47B7480L ^ seed;
		
		hash = 0xE958AC98E3D243C3L * ((byte)i         ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(i >> 8)  ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(i >> 16) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(i >> 24) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(int i) {
        long hash = 0xE958AC98E3D243C3L * ((byte)i ^ 0x4CE4AD8D20F30F20L);
        hash = 0xE958AC98E3D243C3L * ((byte)(i >> 8)  ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(i >> 16) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(i >> 24) ^ (hash << 2) ^ (hash >>> 2));
        
        return hash;
	}

	public static long mzHash64(long l, long seed) {
		long hash = 0xDED46DB8C47B7480L ^ seed;
		
		hash = 0xE958AC98E3D243C3L * ((byte)l         ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 8)  ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 16) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 24) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 32) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 40) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 48) ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xE958AC98E3D243C3L * ((byte)(l >> 56) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(long l) {
        long hash = 0xE958AC98E3D243C3L * ((byte)l ^ 0x4CE4AD8D20F30F20L);
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 8)  ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 16) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 24) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 32) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 40) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 48) ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(l >> 56) ^ (hash << 2) ^ (hash >>> 2));
        
        return hash;
	}

	public static long mzHash64(char c, long seed) {
        long hash = 0xDED46DB8C47B7480L ^ seed;
        
        hash = 0xE958AC98E3D243C3L * ((byte)c        ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xE958AC98E3D243C3L * ((byte)(c >> 8) ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(char c) {
        long hash = 0xE958AC98E3D243C3L * ((byte)c ^ 0x4CE4AD8D20F30F20L);
        hash = 0xE958AC98E3D243C3L * ((byte)(c >> 8) ^ (hash << 2) ^ (hash >>> 2));
        
        return hash;
	}

	public static long mzHashlong(String str, long seed) {
		return mzHash64(str.getBytes(), seed);
	}

	public static long mzHashlong(String str) {
		return mzHash64(str.getBytes(), 0);
	}

	public static long mzHash64(boolean b, long seed) {
		return b ? mzHash64(1, seed) : mzHash64(0, seed);
	}

	public static long mzHash64(boolean b) {
		return b ? 0x96C82C5370677FDAL : 0x95A8D10CABCCA92BL;
	}
	
}



