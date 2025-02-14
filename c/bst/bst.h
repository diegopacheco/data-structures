#ifndef BST_H
#define BST_H

#include <stdbool.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

Node* createNode(int data);
Node* insert(Node* root, int data);
Node* findMin(Node* root);
Node* deleteNode(Node* root, int data);
bool search(Node* root, int data);
void inorderTraversal(Node* root);
void preorderTraversal(Node* root);
void postorderTraversal(Node* root);
void freeTree(Node* root);

#endif