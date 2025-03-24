#include "../include/cpp/array_list.hpp"
#include "test_insertion_last.cpp"
#include "test_removal_last.cpp"
#include "test_get_element.cpp"

void fill_array(ArrayList& array_list, string value) {

    array_list.clear();

    const string filename = "C:/Users/jamqu/Projects/StructComparisons/scripts/inputs/dataset_" + value + ".txt"; 
    
    ifstream file(filename);
    int valor;
        while (file >> valor) {
        array_list.add(valor);
    }
    
    file.close();

}

int main() {
    ArrayList array_list;

    vector <int> values = {1000, 10000, 100000, 1000000, 10000000};

    for (int valor : values) {
        fill_array(array_list, to_string(valor));
        test_dataset_insertion(array_list, to_string(valor), 5000);
        //test_dataset_removal(array_list, to_string(valor), 500000);
    }

    return 0;
}
