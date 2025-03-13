#include "../../include/c99/hash_map.h"
#include "../../include/c99/array_list.h"
#include <stdlib.h>
#include <stdio.h>

HashMap* create_hashmap() {
    HashMap* map = (HashMap*) malloc(sizeof(HashMap));
    init_hashmap(map);
    return map;
}

void init_hashmap(HashMap* map) {
    map->table = (ArrayList**) malloc(HASH_MAP_INITIAL_CAPACITY * sizeof(ArrayList*));
    map->capacity = HASH_MAP_INITIAL_CAPACITY;
    map->size = 0;

    for (int i = 0; i < map->capacity; i++) {
        map->table[i] = NULL;
    }
}

void free_hashmap(HashMap* map) {
    hashmap_clear(map);
    free(map->table);
    free(map);
}

void hashmap_clear(HashMap* map) {
    for (int i = 0; i < map->capacity; i++) {
        if (map->table[i] != NULL) {
            clear_array_list(map->table[i]);
        }
    }
    map->size = 0;
}

unsigned int hash(const char* chave, int capacidade) {
    unsigned int hash = 0;
    for (int i = 0; chave[i] != '\0'; i++) {
        hash = 31 * hash + chave[i];
    }
    return hash % capacidade;
}

void hashmap_put(HashMap* map, const char* key, int value) {
    unsigned int index = hash(key, map->capacity);

    if (map->table[index] == NULL) {
        map->table[index] = create_array_list();  
    }

    add(map->table[index], value);
    map->size++;

    if (map->size >= map->capacity) {
        hashmap_resize(map);
    }
}

int hashmap_get(const HashMap* map, const char* key, int* found) {
    unsigned int index = hash(key, map->capacity);
    if (map->table[index] == NULL) {
        *found = 0;
        return -1;
    }

    *found = 1;
    return array_list_get(map->table[index], 0);  
}

int hashmap_contains_key(const HashMap* map, const char* key) {
    unsigned int index = hash(key, map->capacity);
    return map->table[index] != NULL;
}

int hashmap_contains_value(const HashMap* map, int value) {
    for (int i = 0; i < map->capacity; i++) {
        if (map->table[i] != NULL && array_list_contains(map->table[i], value)) {
            return 1;
        }
    }
    return 0;
}

void print_hashmap(const HashMap* map) {
    for (int i = 0; i < map->capacity; i++) {
        if (map->table[i] != NULL) {
            printf("Index %d: ", i);
            print_array_list(map->table[i]);
        }
    }
}

void hashmap_remove(HashMap* map, const char* key) {
    unsigned int index = hash(key, map->capacity);
    if (map->table[index] != NULL) {
        free_array_list(map->table[index]);
        map->table[index] = NULL;
        map->size--;
    }
}

int hashmap_size(const HashMap* map) {
    return map->size;
}

int hashmap_is_empty(const HashMap* map) {
    if (map->size == 0) return 1;
    return 0;
}

void hashmap_resize(HashMap* map) {
    int new_capacity = map->capacity * 2;
    ArrayList** new_table = (ArrayList**)malloc(new_capacity * sizeof(ArrayList*));

    for (int i = 0; i < new_capacity; i++) {
        new_table[i] = NULL;
    }

    for (int i = 0; i < map->capacity; i++) {
        if (map->table[i] != NULL) {
            for (int j = 0; j < array_list_size(map->table[i]); j++) {
                int value = array_list_get(map->table[i], j);
                unsigned int index = hash((const char*)&value, new_capacity);
                if (new_table[index] == NULL) {
                    new_table[index] = create_array_list();
                }
                add(new_table[index], value);
            }
        }
    }

    for (int i = 0; i < map->capacity; i++) {
        if (map->table[i] != NULL) {
            free_array_list(map->table[i]);
        }
    }
    free(map->table);

    map->table = new_table;
    map->capacity = new_capacity;
}
