#ifndef HASHMAP_H
#define HASHMAP_H

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "../../include/c99/array_list.h"

#define HASH_MAP_INITIAL_CAPACITY 16  
#define LOAD_FACTOR 0.75      



typedef struct {
    ArrayList** table;
    int capacity;
    int size;
} HashMap;

//inicialização
HashMap* create_hashmap();
void init_hashmap(HashMap* map);
void free_hashmap(HashMap* map);

//hash
unsigned int hash(const char* chave, int capacidade);

//inserção
void hashmap_put(HashMap* map, const char* chave, int valor);

//acesso
int hashmap_get(const HashMap* map, const char* chave, int* found);
int hashmap_contains_key(const HashMap* map, const char* key);
int hashmap_contains_value(const HashMap* map, int value);
void print_hashmap(const HashMap* map);

//remoção
void hashmap_remove(HashMap* map, const char* key);
void hashmap_clear(HashMap* map);

//utilidades
int hashmap_size(const HashMap* map);
int hashmap_is_empty(const HashMap* map);
void hashmap_resize(HashMap* map);

#endif
