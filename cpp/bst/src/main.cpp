#include "bst.h"

int main() {
    BST bst;

    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);

    std::cout << "Inorder traversal of the BST: ";
    bst.inorderTraversal();

    std::cout << "Preorder traversal of the BST: ";
    bst.preorderTraversal();

    std::cout << "Postorder traversal of the BST: ";
    bst.postorderTraversal();

    if (bst.search(40)) {
        std::cout << "40 is found in the BST" << std::endl;
    } else {
        std::cout << "40 is not found in the BST" << std::endl;
    }

    bst.remove(30);
    std::cout << "Inorder traversal after deleting 30: ";
    bst.inorderTraversal();

    return 0;
}