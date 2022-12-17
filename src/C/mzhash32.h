#ifndef _MZHASH32_H
#define _MZHASH32_H

#include <stdlib.h> // size_t
#include <stdint.h> // uint32_t

#ifdef __cplusplus
extern "C" {
#endif

#define MZ_HASH_32_DEFAULT_SEED		0;

uint32_t mzhash32(const int8_t *data, size_t length, uint32_t seed);

#ifdef __cplusplus
}
#endif

#endif
