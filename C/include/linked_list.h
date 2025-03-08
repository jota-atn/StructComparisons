#ifndef LINKED_LIST_H
#define LINKED_LIST_H

typedef struct Node {
	int valor;
	struct Node* next;
} Node;

typedef struct {
	Node* head;
} LinkedList;

LinkedList* create_list();

// inserção
void add_first(LinkedList* list, int elemento);
void add_last(LinkedList* list, int elemento);
void add_at_index(LinkedList* list, int elemento);

// remoção
void remove_first(LinkedList* list, int elemento);
void remove_last(LinkedList* list, int elemento);
void remove_elemento(LinkedList* list, int elemento);

// outras operações
int get(LinkedList* list, int index);
int index_of(LinkedList* list, int elemento);
int contains(LinkedList* list, int elemento);
int size(LinkedList* list);
int is_empty(LinkedList* list);
void clear(LinkedList* list);
void print_list(LinkedList* list);
void free_list(LinkedList* list);

#endif
