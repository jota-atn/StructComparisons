#include "../../include/cpp/linked_list.hpp"

LinkedList::LinkedList() {
}

LinkedList::~LinkedList() {
}

void LinkedList::add_first(int elemento) {
    linked_list.push_front(elemento);
}

void LinkedList::add_middle(int elemento) {
    size_t middle_index = linked_list.size() / 2;
    auto it = linked_list.begin();
    advance(it, middle_index);
    linked_list.insert(it, elemento);
}


void LinkedList::add_last(int elemento) {
    linked_list.push_back(elemento);
}

void LinkedList::remove_first() {
    if (!linked_list.empty()) {
        linked_list.pop_front();
    }
}

void LinkedList::remove_middle() {
    if (linked_list.empty()) return;

    size_t middle_index = linked_list.size() / 2;
    auto it = linked_list.begin();
    advance(it, middle_index);
    linked_list.erase(it);
}


void LinkedList::remove_last() {
    if (!linked_list.empty()) {
        linked_list.pop_back();
    }
}

int LinkedList::get_first() {
    if (linked_list.empty()) return linked_list.front();

    return -1;

}

int LinkedList::get_last() {
    if (linked_list.empty()) return linked_list.back();

    return -1;

}

int LinkedList::get_middle() {
    if (!linked_list.empty()) {
        size_t middle_index = linked_list.size() / 2;
        auto it = linked_list.begin();
        advance(it, middle_index);
        return *it;
    }

    return -1;

}

bool LinkedList::contains(int elemento) {
    return find(linked_list.begin(), linked_list.end(), elemento) != linked_list.end();
}

int LinkedList::index_of(int elemento) {
    int index = 0;
    for (auto it = linked_list.begin(); it != linked_list.end(); ++it, ++index) {
        if (*it == elemento) {
            return index;
        }
    }
    return -1;
}

bool LinkedList::is_empty() {
    return linked_list.empty();
}

void LinkedList::clear() {
    linked_list.clear();
}

void LinkedList::fill_list(string value) {
    linked_list.clear();

    const string filename = "../../scripts/inputs/dataset_" + value + ".txt"; 

    
    ifstream file(filename);
    if (!file) {
        cerr << "Erro ao abrir o arquivo: " << filename << endl;
        return;
    }

    int valor;
    while (file >> valor) {
        add_last(valor);
    }
    
    file.close();
}