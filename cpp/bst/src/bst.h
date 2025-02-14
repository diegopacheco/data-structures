#ifndef BST_H
#define BST_H

#include <iostream>

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int data) : data(data), left(nullptr), right(nullptr) {}
};

class BST {
public:
    BST() : root(nullptr) {}
    ~BST();

    void insert(int data);
    bool search(int data) const;
    void remove(int data);

    void inorderTraversal() const;
    void preorderTraversal() const;
    void postorderTraversal() const;

private:
    Node* root;

    Node* insertRecursive(Node* root, int data);
    Node* findMin(Node* root) const;
    Node* deleteNodeRecursive(Node* root, int data);
    void inorderTraversalRecursive(Node* root) const;
    void preorderTraversalRecursive(Node* root) const;
    void postorderTraversalRecursive(Node* root) const;
    void freeMemory(Node* node);
};

#endif