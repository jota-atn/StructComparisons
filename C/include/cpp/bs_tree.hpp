#ifndef BST_H
#define BST_H

#include <iostream>

using namespace std;

class BST {
    private:
        struct Node {
            int valor;
            Node* left;
            Node* right;
            Node(int v) : valor(v), left(nullptr), right(nullptr) {}
        };
        Node* root;
        void insert(Node*& node, int valor);
        void clear(Node* node);
    public:
        BST();
        ~BST();
        void insert(int valor);
        void clear();
};
    
#endif