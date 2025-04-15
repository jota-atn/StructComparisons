#include "../../include/cpp/hash_map.hpp"
#include "testes_hashmap.hpp"

int main() {
    HashMap hashmap;

    test_dataset_single_element_access(hashmap, 500);
    test_dataset_single_removal(hashmap, 500);
    test_lookup_inexistent(hashmap, 500);
    test_dataset_fill_hashmap(hashmap, 30);

    return 0;
}
