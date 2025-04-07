#include "../../include/cpp/hash_map.hpp"

HashMap::HashMap() {}

void HashMap::put(int chave, int valor) {
    map[chave] = valor;
}

bool HashMap::contains(int chave) {
    return map.find(chave) != map.end();
}

int HashMap::get(int chave) {
    if (contains(chave)) {
        return map[chave];
    }
    return -1;
}

void HashMap::remove(int chave) {
    map.erase(chave);
}

size_t HashMap::size() {
    return map.size();
}

void HashMap::clear() {
    map.clear();
}

HashMap::~HashMap() {}
