#ifndef ARRAY_LIST_H
#define ARRAY_LIST_H

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class ArrayList {
private:
    vector<int> array_list;

public:
    void add(int valor);
    void remove(int index);
    int get(int index);
    void reserve(size_t capacity);
    bool is_empty();
    bool contains(int elemento);
    size_t size();
    void clear();
    void show();
};

#endif
