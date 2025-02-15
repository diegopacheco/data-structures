@main def main(): Unit = {
    val bst: Bst = new SimpleBst()
    bst.insert(50)
    bst.insert(30)
    bst.insert(20)
    bst.insert(40)
    bst.insert(70)
    bst.insert(60)
    bst.insert(80)

    print("Inorder traversal of the BST: ")
    bst.inorderTraversal()

    print("Preorder traversal of the BST: ")
    bst.preorderTraversal()

    print("Postorder traversal of the BST: ")
    bst.postorderTraversal()

    if (bst.search(40)) {
      println("40 is found in the BST")
    } else {
      println("40 is not found in the BST")
    }

    bst.remove(30)
    print("Inorder traversal after deleting 30: ")
    bst.inorderTraversal()
}