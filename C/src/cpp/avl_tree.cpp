#include "../../include/cpp/avl_tree.hpp"
#include <algorithm>
#include <stdlib.h>
#include <iostream>
#include <fstream>

using namespace std;

AVLTree::AVLTree() : root(nullptr) {}

AVLTree::~AVLTree() {
    destroy(root);
}

void AVLTree::destroy(Node* node) {
    if (node) {
        destroy(node->left);
        destroy(node->right);
        delete node;
    }
}

int AVLTree::get_height(Node* node) {
    return node ? node->height : 0;
}

int AVLTree::get_balance(Node* node) {
    return node ? get_height(node->left) - get_height(node->right) : 0;
}

AVLTree::Node* AVLTree::rotate_left(Node* x) {
    Node* y = x->right;
    Node* T2 = y->left;

    y->left = x;
    x->right = T2;

    x->height = std::max(get_height(x->left), get_height(x->right)) + 1;
    y->height = std::max(get_height(y->left), get_height(y->right)) + 1;

    return y;
}

AVLTree::Node* AVLTree::rotate_right(Node* y) {
    Node* x = y->left;
    Node* T2 = x->right;

    x->right = y;
    y->left = T2;

    y->height = std::max(get_height(y->left), get_height(y->right)) + 1;
    x->height = std::max(get_height(x->left), get_height(x->right)) + 1;

    return x;
}

AVLTree::Node* AVLTree::insert(Node* node, int key) {
    if (!node) return new Node(key);

    if (key < node->key)
        node->left = insert(node->left, key);
    else if (key > node->key)
        node->right = insert(node->right, key);
    else
        return node;

    node->height = 1 + std::max(get_height(node->left), get_height(node->right));

    int balance = get_balance(node);

    if (balance > 1 && key < node->left->key)
        return rotate_right(node);
    if (balance < -1 && key > node->right->key)
        return rotate_left(node);
    if (balance > 1 && key > node->left->key) {
        node->left = rotate_left(node->left);
        return rotate_right(node);
    }
    if (balance < -1 && key < node->right->key) {
        node->right = rotate_right(node->right);
        return rotate_left(node);
    }

    return node;
}

AVLTree::Node* AVLTree::remove(Node* node, int key) {
    if (!node) return nullptr;

    if (key < node->key)
        node->left = remove(node->left, key);
    else if (key > node->key)
        node->right = remove(node->right, key);
    else {
        if (!node->left || !node->right) {
            Node* temp = node->left ? node->left : node->right;
            delete node;
            return temp;
        }

        Node* temp = min_node(node->right);
        node->key = temp->key;
        node->right = remove(node->right, temp->key);
    }

    node->height = 1 + std::max(get_height(node->left), get_height(node->right));
    int balance = get_balance(node);

    if (balance > 1 && get_balance(node->left) >= 0)
        return rotate_right(node);
    if (balance > 1 && get_balance(node->left) < 0) {
        node->left = rotate_left(node->left);
        return rotate_right(node);
    }
    if (balance < -1 && get_balance(node->right) <= 0)
        return rotate_left(node);
    if (balance < -1 && get_balance(node->right) > 0) {
        node->right = rotate_right(node->right);
        return rotate_left(node);
    }

    return node;
}

AVLTree::Node* AVLTree::find(Node* node, int key) {
    if (!node || node->key == key) return node;
    return key < node->key ? find(node->left, key) : find(node->right, key);
}

AVLTree::Node* AVLTree::min_node(Node* node) {
    while (node && node->left) node = node->left;
    return node;
}

AVLTree::Node* AVLTree::max_node(Node* node) {
    while (node && node->right) node = node->right;
    return node;
}

AVLTree::Node* AVLTree::get_successor_node(Node* node, int key) {
    Node* succ = nullptr;
    while (node) {
        if (key < node->key) {
            succ = node;
            node = node->left;
        } else {
            node = node->right;
        }
    }
    return succ;
}

AVLTree::Node* AVLTree::get_predecessor_node(Node* node, int key) {
    Node* pred = nullptr;
    while (node) {
        if (key > node->key) {
            pred = node;
            node = node->right;
        } else {
            node = node->left;
        }
    }
    return pred;
}

void AVLTree::insert(int key) {
    root = insert(root, key);
}

void AVLTree::remove(int key) {
    root = remove(root, key);
}

bool AVLTree::search(int key) {
    return find(root, key) != nullptr;
}

int AVLTree::min() {
    Node* n = min_node(root);
    return n ? n->key : -1;
}

int AVLTree::max() {
    Node* n = max_node(root);
    return n ? n->key : -1;
}

int AVLTree::successor(int key) {
    Node* succ = get_successor_node(root, key);
    return succ ? succ->key : -1;
}

int AVLTree::predecessor(int key) {
    Node* pred = get_predecessor_node(root, key);
    return pred ? pred->key : -1;
}

void AVLTree::clear() {
    destroy(root);
    root = nullptr;
}

void AVLTree::fill_tree(string value) {
    clear();

    const std::string filename = "../../scripts/inputs/dataset_" + value + ".txt";

    std::ifstream file(filename);
    if (!file) {
        std::cerr << "Erro ao abrir o arquivo: " << filename << std::endl;
        return;
    }

    int number;
    while (file >> number) {
        insert(number);
    }

    file.close();
}
