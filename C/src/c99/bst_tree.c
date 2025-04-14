#include <stdio.h>
#include <stdlib.h>
#include "../../include/c99/bst_tree.h"

Node* create_bst() {
    return NULL;
}

Node* init_bst(Node *root) {
    if (root != NULL) {
        freeTree(root);
    }
    return NULL;
}

void free_bst(Node *root) {
    freeTree(root);
}

Node* createNode(int data) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        return NULL;
    }
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

Node* insert(Node *root, int data) {
    if (root == NULL) {
        return createNode(data);
    }
    
    if (data < root->data) {
        root->left = insert(root->left, data);
    } 
    
    else if (data > root->data) {
        root->right = insert(root->right, data);
    }

    return root;
}

bool search(Node *root, int data) {
    if (root == NULL) {
        return false;
    }
    
    if (data < root->data) {
        return search(root->left, data);
    } 
    
    else if (data > root->data) {
        return search(root->right, data);
    }
    
    else {
        return true;
    }
}

Node* minValueNode(Node *node) {
    Node *current = node;
    while (current && current->left != NULL) {
        current = current->left;
    }
    return current;
}

Node* delete(Node *root, int data) {
    if (root == NULL) {
        return root;
    }

    if (data < root->data) {
        root->left = delete(root->left, data);
    } 
    
    else if (data > root->data) {
        root->right = delete(root->right, data);
    } 
    
    else {
        if (root->left == NULL) {
            Node *temp = root->right;
            free(root);
            return temp;
        } 
        
        else if (root->right == NULL) {
            Node *temp = root->left;
            free(root);
            return temp;
        }

        Node *temp = minValueNode(root->right);
        root->data = temp->data;
        root->right = delete(root->right, temp->data);
    }

    return root;
}

void inorder(Node *root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

void preorder(Node *root) {
    if (root != NULL) {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(Node *root) {
    if (root != NULL) {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->data);
    }
}

void freeTree(Node *root) {
    if (root != NULL) {
        freeTree(root->left);
        freeTree(root->right);
        free(root);
    }
}
