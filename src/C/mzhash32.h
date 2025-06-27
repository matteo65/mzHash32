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

#ifndef _MZHASH32_H
#define _MZHASH32_H

#include <stddef.h> // size_t
#include <stdint.h> // uint32_t

#ifdef __cplusplus
extern "C" {
#endif

#define MZ_HASH_32_DEFAULT_SEED		0;

uint32_t mzhash32(const void* data, size_t length, uint32_t seed);

uint32_t mzhash32_noseed(const void* data, size_t length);

uint32_t mzhash32_str(const char* str, uint32_t seed);

uint32_t mzhash32_str_noseed(const char* str);

#ifdef __cplusplus
}
#endif

#endif
