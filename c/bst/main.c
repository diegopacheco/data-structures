#include <stdio.h>
#include "bst.h"

int main() {
    Node* root = NULL;
    
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);
    
    printf("Inorder traversal of the BST: ");
    inorderTraversal(root);
    printf("\n");

    printf("Preorder traversal of the BST: ");
    preorderTraversal(root);
    printf("\n");

    printf("Postorder traversal of the BST: ");
    postorderTraversal(root);
    printf("\n");
    
    if (search(root, 40)) {
        printf("40 is found in the BST\n");
    } else {
        printf("40 is not found in the BST\n");
    }
    root = deleteNode(root, 30);
    printf("Inorder traversal after deleting 30: ");
    inorderTraversal(root);
    printf("\n");
    freeTree(root);
    
    return 0;
}