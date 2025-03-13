#ifndef ARRAY_LIST_H
#define ARRAY_LIST_H

#include <iostream>
#include <vector>

using namespace std;

class ArrayList {
    private:
        vector<int> array_list;
    public:
        void add(int valor);
        void remove(int index);
        int get(int index);
        bool is_empty();
        bool contains(int elemento);
        size_t size();
        void clear();
};

#endif