#include "bst.h"

BST::~BST() {
    freeMemory(root);
}

void BST::freeMemory(Node* node) {
    if (node != nullptr) {
        freeMemory(node->left);
        freeMemory(node->right);
        delete node;
    }
}

void BST::insert(int data) {
    root = insertRecursive(root, data);
}

Node* BST::insertRecursive(Node* root, int data) {
    if (root == nullptr) {
        return new Node(data);
    }

    if (data < root->data) {
        root->left = insertRecursive(root->left, data);
    } else if (data > root->data) {
        root->right = insertRecursive(root->right, data);
    }
    return root;
}

bool BST::search(int data) const {
    Node* current = root;
    while (current != nullptr) {
        if (data == current->data) {
            return true;
        } else if (data < current->data) {
            current = current->left;
        } else {
            current = current->right;
        }
    }
    return false;
}

void BST::remove(int data) {
    root = deleteNodeRecursive(root, data);
}

Node* BST::findMin(Node* root) const {
    while (root && root->left != nullptr) {
        root = root->left;
    }
    return root;
}

Node* BST::deleteNodeRecursive(Node* root, int data) {
    if (root == nullptr) {
        return nullptr;
    }

    if (data < root->data) {
        root->left = deleteNodeRecursive(root->left, data);
    } else if (data > root->data) {
        root->right = deleteNodeRecursive(root->right, data);
    } else {
        if (root->left == nullptr) {
            Node* temp = root->right;
            delete root;
            return temp;
        } else if (root->right == nullptr) {
            Node* temp = root->left;
            delete root;
            return temp;
        }

        Node* temp = findMin(root->right);
        root->data = temp->data;
        root->right = deleteNodeRecursive(root->right, temp->data);
    }
    return root;
}

void BST::inorderTraversal() const {
    inorderTraversalRecursive(root);
    std::cout << std::endl;
}

void BST::inorderTraversalRecursive(Node* root) const {
    if (root != nullptr) {
        inorderTraversalRecursive(root->left);
        std::cout << root->data << " ";
        inorderTraversalRecursive(root->right);
    }
}

void BST::preorderTraversal() const {
    preorderTraversalRecursive(root);
    std::cout << std::endl;
}

void BST::preorderTraversalRecursive(Node* root) const {
    if (root != nullptr) {
        std::cout << root->data << " ";
        preorderTraversalRecursive(root->left);
        preorderTraversalRecursive(root->right);
    }
}

void BST::postorderTraversal() const {
    postorderTraversalRecursive(root);
    std::cout << std::endl;
}

void BST::postorderTraversalRecursive(Node* root) const {
    if (root != nullptr) {
        postorderTraversalRecursive(root->left);
        postorderTraversalRecursive(root->right);
        std::cout << root->data << " ";
    }
}