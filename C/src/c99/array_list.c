#include "../../include/c99/array_list.h"
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

ArrayList* create_array_list() {
    ArrayList* list = (ArrayList*) malloc(sizeof(ArrayList));
    init_array_list(list);
    return list;
}

void init_array_list(ArrayList* list) {
    list->size = 0;
    list->capacity = ARRAY_LIST_INITIAL_CAPACITY;
    list->array = (int*)malloc(list->capacity * sizeof(int));
}

void free_array_list(ArrayList* list) {
    free(list->array);
    free(list);
}

void resize(ArrayList* list) {
    int new_capacity = list->capacity * 2;
    int* new_array = (int*)realloc(list->array, new_capacity * sizeof(int));

    if (new_array == NULL) {
        printf("Erro ao realocar memória!\n");
        return;
    }

    list->array = new_array;
    list->capacity = new_capacity;
}

void add(ArrayList* list, int elemento) {
    if (list->size == list->capacity) {
        resize(list);
    }

    list->array[list->size] = elemento;
    list->size++;

} 

void array_list_insert(ArrayList* list, int index, int elemento) {
    if (index < 0 || index > list->size) return;

    if (list->size == list->capacity) {
        resize(list);
    }

    for (int i = list->size; i > index; i--) {
        list->array[i] = list->array[i-1];
    }

    list->array[index] = elemento;
    list->size++;
}

int array_list_get(const ArrayList* list, int index) {
    if (index < 0 || index >= list->size) return -1;

    return list->array[index];
}

int array_list_contains(const ArrayList* list, int elemento) {
    for (int i = 0; i < list->size; i++) {
        if (list->array[i] == elemento) return 1;
    }

    return 0;
}

int array_list_index_of(const ArrayList* list, int elemento) {
    for (int i = 0; i < list->size; i++) {
        if (list->array[i] == elemento) return i;
    }
    
    return -1;

}

int array_list_size(const ArrayList* list) {
    return list->size;
}

int array_list_is_empty(const ArrayList* list) {
    if (list->size == 0) return 1;
    return 0;
}

void array_list_remove_at(ArrayList* list, int index) {
    if (index < 0 || index >= list->size) return;

    for (int i = index; i < list->size-1; i++) {
        list->array[i] = list->array[i+1];
    }

    list->array[list->size-1] = 0;

    list->size--;
}

void pop(ArrayList* list) {
    if (list->size == 0) return;

    list->array[list->size-1] = 0;
    list->size--;
}

void clear_array_list(ArrayList* list) {
    for (int i = 0; i < list->size; i++) {
        list->array[i] = 0;
    }

    list->size = 0;
}

void print_array_list(const ArrayList* list) {
    for (int i = 0; i < list->size; i++) {
        printf("%d ", list->array[i]);
    }

    printf("\n");
}

