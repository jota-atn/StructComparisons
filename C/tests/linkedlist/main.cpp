#include "../../include/cpp/linked_list.hpp"
#include "../../include/cpp/output.hpp"
#include "test_insertion_last_one_element.cpp"
#include "test_insertion_last_n_elements.cpp"
#include "test_insertion_inicio_one_element.cpp"
#include "test_insertion_inicio_n_elements.cpp"


int main() {
    LinkedList array_list;

    test_dataset_insertion_last_one_element(array_list, 50000);
    test_dataset_insertion_last_n_elements(array_list, 50000);
    test_dataset_insertion_first_one_element(array_list, 5000);
    test_dataset_insertion_first_n_elements(array_list, 25);
    //test_dataset_insertion_middle(array_list, 50);
    //test_dataset_removal(array_list, 10000);
    //test_dataset_get_inicio(array_list);
    //test_dataset_get_meio(array_list);
    //test_dataset_get_fim(array_list);

    return 0;
}
