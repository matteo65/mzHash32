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

#include "mzhash32.h"

uint32_t mzhash32(const void* data, size_t length, uint32_t seed)
{
	const int8_t *bytes = (const int8_t*)data;
	uint32_t hash = 0x514430D1 | seed;

	while(length--)
		hash = 0x003C50DB * (*bytes++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

uint32_t mzhash32_noseed(const void* data, size_t length)
{
	const int8_t *bytes = (const int8_t*)data;
	uint32_t hash = 0x514430D1;

	while(length--)
		hash = 0x003C50DB * (*bytes++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

uint32_t mzhash32_str(const char* str, uint32_t seed)
{
	uint32_t hash = 0x514430D1 | seed;

	while(*str)
		hash = 0x003C50DB * (*str++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

uint32_t mzhash32_str_noseed(const char* str)
{
	uint32_t hash = 0x514430D1;

	while(*str)
		hash = 0x003C50DB * (*str++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}
