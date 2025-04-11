#ifndef AVL_TREE_H
#define AVL_TREE_H

class AVLTree {
private:
    struct Node {
        int key;
        int height;
        Node* left;
        Node* right;

        Node(int k) : key(k), height(1), left(nullptr), right(nullptr) {}
    };

    Node* root;

    void destroy(Node* node);
    int get_height(Node* node);
    int get_balance(Node* node);

    Node* rotate_left(Node* x);
    Node* rotate_right(Node* y);

    Node* insert(Node* node, int key);
    Node* remove(Node* node, int key);
    Node* find(Node* node, int key);

    Node* min_node(Node* node);
    Node* max_node(Node* node);
    Node* get_successor_node(Node* node, int key);
    Node* get_predecessor_node(Node* node, int key);

public:
    AVLTree();
    ~AVLTree();

    void insert(int key);
    void remove(int key);
    bool search(int key);
    void fill_tree(string value);
    void clear();

    int min();     
    int max();           
    int successor(int k); 
    int predecessor(int k); 
};

#endif
