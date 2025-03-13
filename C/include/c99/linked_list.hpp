#ifndef LISTA_ENCADEADA_HPP
#define LISTA_ENCADEADA_HPP

class LinkedList {
public:
    LinkedList();
    void add_first(int elemento);
    void add_last(int elemento);
    void remove_first();
    void remove_last();
    bool contains(int elemento);
    int index_of(int elemento);
    int size();
    bool is_empty();
    void clear();
    void print_list();
    ~LinkedList();
};

#endif