/**
 * mzhash32
 *  
 * Strong, fast, simple non-cryptographic 32-bit hash function
 * 
 * Copyright(C) 2022 - Matteo Zapparoli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
public class HashFunction {
	
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

}
