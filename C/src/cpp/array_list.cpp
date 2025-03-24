#include "../../include/cpp/array_list.hpp"

void ArrayList::add(int valor) {
    array_list.push_back(valor);
}

void ArrayList::remove(int index) {
    if (index >= 0 && index < array_list.size()) {
        array_list.erase(array_list.begin() + index);
    }
}

void ArrayList::reserve(size_t capacity) {
    array_list.reserve(capacity);
}

int ArrayList::get(int index) {
    if (index >= 0 && index < array_list.size()) {
        return array_list[index];
    }
    return -1;
}

bool ArrayList::is_empty() {
    return array_list.empty();
}

bool ArrayList::contains(int elemento) {
    return find(array_list.begin(), array_list.end(), elemento) != array_list.end();
}

void ArrayList::clear() {
    array_list.clear();
}

void ArrayList::fill_array(string value) {

    array_list.clear();

    const string filename = "C:/Users/jamqu/Projects/StructComparisons/scripts/inputs/dataset_" + value + ".txt"; 
    
    ifstream file(filename);
    int valor;
        while (file >> valor) {
        ArrayList::add(valor);
    }
    
    file.close();

}

size_t ArrayList::size() {
    return array_list.size();
}

void ArrayList::show() {
    if (array_list.empty()) {
        cout << "ArrayList is empty." << endl;
    } else {
        cout << "ArrayList contents: ";
        for (int value : array_list) {
            cout << value << " ";
        }
        cout << endl;
    }
}