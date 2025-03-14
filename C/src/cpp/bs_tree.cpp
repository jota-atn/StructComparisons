#include "../../include/cpp/bs_tree.hpp"
#include <iostream>

class BST {
    private:
        struct Node {
            int valor;
            Node* left;
            Node* right;
            Node(int v) : valor(v), left(nullptr), right(nullptr) {}
        };
        Node* root;
        
        void insert(Node*& node, int valor) {
            if (!node) {
                node = new Node(valor);
            } else if (valor < node->valor) {
                insert(node->left, valor);
            } else {
                insert(node->right, valor);
            }
        }
        
        void clear(Node* node) {
            if (node) {
                clear(node->left);
                clear(node->right);
                delete node;
            }
        }
        
    public:
        BST() : root(nullptr) {}
        
        ~BST() {
            clear(root);
        }
        
        void insert(int valor) {
            insert(root, valor);
        }
        
        void clear() {
            clear(root);
            root = nullptr;
        }
    };