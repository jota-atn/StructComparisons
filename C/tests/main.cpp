#include "../include/cpp/array_list.hpp"
#include "test_insertion_end.cpp"
#include "test_removal_end.cpp"
#include "test_get_element.cpp"


int main() {
    ArrayList arrayList;

    vector <int> values = {1000, 10000, 100000, 1000000, 10000000};

    for (int value : values) {
        test_dataset_get(arrayList, to_string(value));
    }

    return 0;
}
