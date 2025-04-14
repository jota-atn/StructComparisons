#include "../../include/c99/linked_list.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void init_linked_list(LinkedList* list) {
    list->head = NULL;
    list->size = 0;
}

LinkedList* create_linked_list() {
    LinkedList* list = (LinkedList*)malloc(sizeof(LinkedList));
    init_linked_list(list);
    return list;
}

void add_first(LinkedList* list, int elemento) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->valor = elemento;
    new_node->next = list->head;
    list->head = new_node;
    list->size++;
}

void add_last(LinkedList* list, int elemento) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->valor = elemento;
    new_node->next = NULL; 

    if (list->head == NULL) {
        list->head = new_node;
    }

    else {
        Node* temp = list->head;
        while (temp->next) {
            temp = temp->next;
        }
    
        temp->next = new_node;
    
    }

    ;
    list->size++;
}

void add_at_index(LinkedList* list, int elemento, int index) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->valor = elemento;
    new_node->next = NULL;

    if (list->head == NULL) {
        list->head = new_node;
    }

    else {
        int contador = 0;

        Node* temp = list->head;
        while (temp->next && contador < index) {
            temp = temp->next;
            contador++;
        }

        temp->next = new_node;

    }

    ;
    list->size++;

}

void remove_first(LinkedList* list) {
    if (list->head == NULL) return;
    
    Node* temp = list->head;
    list->head = list->head->next;
    
    list->size--;
}

void remove_last(LinkedList* list) {
    if (list->head == NULL) return;

    if (list->head->next == NULL) {
        free(list->head);
        list->head = NULL;
    }

    else {
        Node* temp = list->head;
        while (temp->next->next) {
            temp = temp->next;
        }

        free(temp->next);
        temp->next = NULL;
    }   

    
    list->size--;

}

void remove_elemento(LinkedList* list, int elemento) {
    if (list->head == NULL) return;

    if (list->head->valor == elemento) {
        Node* temp = list->head;
        list->head = list->head->next;
        
        list->size--;
        return;
    }

    Node* temp = list->head;

    while (temp->next) {
        if (temp->next->valor == elemento) {
            Node* aux = temp->next;
            temp->next = temp->next->next;
            free(aux);
        }
    }

    
    list->size--;

}

int get(LinkedList* list, int index) {
    if (list->head == NULL) return -1;

    int contador = 0;
    Node* temp = list->head;

    while (temp && contador < index) {
        if (temp->valor == index) return temp->valor;


        temp = temp->next;
        contador++;
    }

    return -1;

}

int contains(LinkedList* list, int elemento) {

    Node* temp = list->head;

    while (temp) {
        if (temp->valor == elemento) return 1;
        temp = temp->next;
    }

    return 0;

}

int size(LinkedList* list) {
    return list->size;
}

int is_empty(LinkedList* list) {
    if (list->size == 0) return 1;
    return 0;
}

void clear(LinkedList* list) {
    Node* temp = list->head;

    while (temp) {
        Node* aux = temp;
        temp = temp->next;
        free(aux);
    }

    list->head = NULL;
    list->size = 0;
}

void print_linked_list(LinkedList* list) {
    Node* temp = list->head;

    while (temp) {
        printf("%d ", temp->valor);
        temp = temp->next;
    }

    printf("\n");

}

void free_list(LinkedList* list) {
    clear(list);
    free(list);
}