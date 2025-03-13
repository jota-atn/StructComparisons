#include <iostream>
#include <list>

using namespace std;

class LinkedList {
private:
    list<int> linked_list;

public:
    LinkedList() {}

    void add_first(int elemento) {
        linked_list.push_front(elemento);
    }

    void add_last(int elemento) {
        linked_list.push_back(elemento);
    }

    void remove_first() {
        if (!linked_list.empty()) {
            linked_list.pop_front();
        }
    }

    void remove_last() {
        if (!linked_list.empty()) {
            linked_list.pop_back();
        }
    }

    bool contains(int elemento) {
        return find(linked_list.begin(), linked_list.end(), elemento) != linked_list.end();
    }

    int index_of(int elemento) {
        int index = 0;
        for (auto it = linked_list.begin(); it != linked_list.end(); ++it, ++index) {
            if (*it == elemento) {
                return index;
            }
        }
        return -1;
    }

    int size() {
        return linked_list.size();
    }

    bool is_empty() {
        return linked_list.empty();
    }

    void clear() {
        linked_list.clear();
    }

    ~LinkedList() {}
};
