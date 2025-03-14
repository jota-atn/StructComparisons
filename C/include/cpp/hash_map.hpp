#ifndef HASH_MAP_H
#define HASH_MAP_H

#include <iostream>
#include <unordered_map>

class HashMap {
    private:
        unordered_map<int, int> map;
    public:
        HashMap();
        void put(int chave, int valor);
        bool contains(int chave);
        int get(int chave);
        void remove(int chave);
        size_t size();
        void clear();
        ~HashMap();
};

#endif