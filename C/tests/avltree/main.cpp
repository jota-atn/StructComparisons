#include "../../include/cpp/avl_tree.hpp"
#include "testes_avl_tree.hpp"

int main() {

    AVLTree avl_tree;

    test_dataset_max(avl_tree, 50);
    test_dataset_min(avl_tree, 50);
    test_dataset_insertion_n_elements(avl_tree, 50);
    test_dataset_single_element_access(avl_tree, 50);
    test_dataset_single_element_remotion(avl_tree, 50);
    test_dataset_successor(avl_tree, 50);
    test_dataset_predecessor(avl_tree, 50);
    test_dataset_fill_avltree(avl_tree, 50);

    return 0;

}
