#include "../../include/cpp/array_list.h"

using namespace std;

#include <iostream>
#include <vector>

using namespace std;

class ArrayList {
private:
    vector<int> array_list;

public:
    void add(int valor) {
        array_list.push_back(valor);
    }

    void remove(int index) {
        if (index >= 0 && index < array_list.size()) {
            array_list.erase(array_list.begin() + index);
        }
    }

    int get(int index) {
        if (index >= 0 && index < array_list.size()) {
            return array_list[index];
        }
        return -1;
    }

    bool is_empty() {
        return array_list.empty();
    }

    bool contains(int elemento) {
        return find(array_list.begin(), array_list.end(), elemento) != array_list.end();
    }

    size_t size() {
        return array_list.size();
    }

    void clear() {
        array_list.clear();
    }
};

    