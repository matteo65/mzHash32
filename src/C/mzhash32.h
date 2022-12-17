#ifndef _MZHASH32_H
#define _MZHASH32_H

#include <stdint.h> // uint32_t

#ifdef __cplusplus
extern "C" {
#endif

#define MZ_HASH_32_DEFAULT_SEED		0;

uint32_t mzhash32(const int8_t *data, int length, uint32_t seed);

#ifdef __cplusplus
}
#endif

#endif
