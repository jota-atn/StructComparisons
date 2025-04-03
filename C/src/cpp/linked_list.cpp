#include "../../include/cpp/linked_list.hpp"

LinkedList::LinkedList() {
}

LinkedList::~LinkedList() {
}

void LinkedList::add_first(int elemento) {
    linked_list.push_front(elemento);
}

void LinkedList::add_last(int elemento) {
    linked_list.push_back(elemento);
}

void LinkedList::remove_first() {
    if (!linked_list.empty()) {
        linked_list.pop_front();
    }
}

void LinkedList::remove_last() {
    if (!linked_list.empty()) {
        linked_list.pop_back();
    }
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

void LinkedList::fill_list(std::string value) {
    linked_list.clear();

    const std::string filename = "C:/Users/jamqu/Projects/StructComparisons/scripts/inputs/dataset_" + value + ".txt";
    
    std::ifstream file(filename);
    if (!file) {
        std::cerr << "Erro ao abrir o arquivo: " << filename << std::endl;
        return;
    }

    int valor;
    while (file >> valor) {
        add_last(valor);
    }
    
    file.close();
}