#include "../../include/cpp/array_list.hpp"
#include "test_insertion_last.cpp"
#include "test_insertion_inicio.cpp"
#include "test_insertion_inicio_elemento_unico.cpp"
#include "test_insertion_meio.cpp"
#include "test_removal_last.cpp"
#include "test_get_element_inicio.cpp"
#include "test_get_element_meio.cpp"
#include "test_get_element_fim.cpp"

int main() {
    ArrayList array_list;

    test_dataset_insertion(array_list, 50, 10000);
    test_dataset_insertion_first_one_element(array_list, 500);
    //test_dataset_insertion_first(array_list, 50);
    //test_dataset_insertion_middle(array_list, 50);
    //test_dataset_removal(array_list, 10000);
    //test_dataset_get_inicio(array_list);
    //test_dataset_get_meio(array_list);
    //test_dataset_get_fim(array_list);

    return 0;
}
