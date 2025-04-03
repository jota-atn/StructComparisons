#ifndef LINKED_LIST_HPP
#define LINKED_LIST_HPP

#include <iostream>
#include <list>
#include <fstream>
#include <algorithm>

using namespace std;

class LinkedList {
    private:
        list<int> linked_list;

    public:
        LinkedList();
        void add_first(int elemento);
        void add_last(int elemento);
        void remove_first();
        void remove_last();
        bool contains(int elemento);
        int index_of(int elemento);
        bool is_empty();
        void clear();
        void fill_list(string value);
        ~LinkedList();
};

#endif