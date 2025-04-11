#include "../../include/cpp/array_list.hpp"
#include "testes_arraylist.hpp"

int main() {
    ArrayList array_list;

    test_dataset_insertion_last_one_element(array_list, 50000);
    test_dataset_insertion_last_n_elements(array_list, 50000);
    test_dataset_get_inicio(array_list, 5000);
    test_dataset_get_meio(array_list, 5000);
    test_dataset_get_fim(array_list, 5000);
    test_dataset_insertion_first_one_element(array_list, 25);
    test_dataset_insertion_first_n_elements(array_list, 25);
    test_dataset_insertion_middle_n_elements(array_list, 50);
    test_dataset_insertion_middle_one_element(array_list, 50);
    test_dataset_remove_last_one_element(array_list, 10000);
    test_dataset_remove_last_n_elements(array_list, 10000);
    test_dataset_remove_first_one_element(array_list, 10000);
    test_dataset_remove_first_n_elements(array_list, 10000);
    test_dataset_search_element(array_list, 10000);
    test_dataset_fill_arraylist(array_list, 30);

    return 0;
}
