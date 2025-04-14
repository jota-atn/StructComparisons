#ifndef array_list_h
#define array_list_h

#include <stdbool.h>

#define ARRAY_LIST_INITIAL_CAPACITY 10

typedef struct {
    int* array;
    int size;
    int capacity;
} ArrayList;

//inicialização
ArrayList* create_array_list();
void init_array_list(ArrayList* list);
void free_array_list(ArrayList* list);

//inserção
void add(ArrayList* list, int element);
void array_list_insert(ArrayList* list, int index, int element);

//acesso
int array_list_get(const ArrayList* list, int index);
int array_list_contains(const ArrayList* list, int element);
int array_list_index_of(const ArrayList* list, int element);
int array_list_size(const ArrayList* list);
int array__list_is_empty(const ArrayList* list);

//remoção
void remove_at(ArrayList* list, int index);
void pop(ArrayList* list);
void clear_array_list(ArrayList* list);

//exibição
void print_array_list(const ArrayList* list);

#endif