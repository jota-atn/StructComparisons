#include "../../include/cpp/linked_list.hpp"
#include "testes_linkedlist.hpp"

int main() {
    LinkedList linked_list;

    test_dataset_insertion_last_one_element(linked_list, 50000);
    test_dataset_insertion_last_n_elements(linked_list, 50000);
    test_search_element(linked_list, 10000000);
    test_dataset_get_inicio(linked_list);
    test_dataset_get_meio(linked_list);
    test_dataset_get_fim(linked_list);
    test_dataset_insertion_first_one_element(linked_list, 5000);
    test_dataset_insertion_first_n_elements(linked_list, 25);
    test_dataset_remove_last_one_element(linked_list, 10000);
    test_dataset_remove_last_n_elements(linked_list, 10000);

    return 0;
}
