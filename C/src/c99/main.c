#include <stdlib.h>
#include <stdio.h>
#include "../../include/c99/linked_list.h"
#include "../../include/c99/array_list.h"
#include "../../include/c99/hash_map.h"
#include "../../include/c99/bst_tree.h"

int main(void) {

    LinkedList* linked_list = create_linked_list();
    ArrayList* array_list = create_array_list();
    HashMap* hash_map = create_hashmap();
    //    BSTTree* bst_tree = create_bst_tree();


    hashmap_put(hash_map, "name", 100);
    hashmap_put(hash_map, "age", 25);
    hashmap_put(hash_map, "salary", 50000);
    hashmap_put(hash_map, "city", 2025);

    printf("HashMap after insertion:\n");
    print_hashmap(hash_map);

    free_hashmap(hash_map);

    return 1;

}