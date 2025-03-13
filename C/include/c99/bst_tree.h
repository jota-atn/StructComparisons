#ifndef BST_H
#define BST_H

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node;

Node* create_bst();
Node* init_bst(Node *root);
Node* create_node(int data);
Node* insert(Node *root, int data);
int search(Node *root, int data);
Node* delete(Node *root, int data);
Node* min_value_node(Node *node);
Node* max_value_node(Node *node);
void inorder(Node *root);
void preorder(Node *root);
void postorder(Node *root);
void free_tree(Node *root);

#endif
