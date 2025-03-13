#include "../../include/cpp/hash_map.hpp"
#include <iostream>
#include <unordered_map>

using namespace std;

class HashMap {
    private:
        unordered_map<int, int> map;
    public:
        void put(int chave, int valor) {
            map[chave] = valor;
        }
        
        bool contains(int chave) {
            return map.find(chave) != map.end();
        }
        
        int get(int chave) {
            if (contains(chave)) {
                return map[chave];
            }
            return -1;
        }
        
        void remove(int chave) {
            map.erase(chave);
        }
        
        size_t size() {
            return map.size();
        }
        
        void clear() {
            map.clear();
        }
    };