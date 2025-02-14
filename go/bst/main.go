package main

import "fmt"

func main() {
	var root *Node
	root = Insert(root, 50)
	root = Insert(root, 30)
	root = Insert(root, 20)
	root = Insert(root, 40)
	root = Insert(root, 70)
	root = Insert(root, 60)
	root = Insert(root, 80)

	fmt.Print("Inorder traversal of the BST: ")
	InorderTraversal(root)
	fmt.Println()

	fmt.Print("Preorder traversal of the BST: ")
	PreorderTraversal(root)
	fmt.Println()

	fmt.Print("Postorder traversal of the BST: ")
	PostorderTraversal(root)
	fmt.Println()

	if Search(root, 40) {
		fmt.Println("40 is found in the BST")
	} else {
		fmt.Println("40 is not found in the BST")
	}

	root = DeleteNode(root, 30)
	fmt.Print("Inorder traversal after deleting 30: ")
	InorderTraversal(root)
	fmt.Println()
}
