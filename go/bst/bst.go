package main

import "fmt"

type Node struct {
	Data  int
	Left  *Node
	Right *Node
}

func Insert(root *Node, data int) *Node {
	if root == nil {
		return &Node{Data: data, Left: nil, Right: nil}
	}

	if data < root.Data {
		root.Left = Insert(root.Left, data)
	} else if data > root.Data {
		root.Right = Insert(root.Right, data)
	}

	return root
}

func FindMin(root *Node) *Node {
	for root.Left != nil {
		root = root.Left
	}
	return root
}

func DeleteNode(root *Node, data int) *Node {
	if root == nil {
		return nil
	}

	if data < root.Data {
		root.Left = DeleteNode(root.Left, data)
	} else if data > root.Data {
		root.Right = DeleteNode(root.Right, data)
	} else {
		if root.Left == nil {
			return root.Right
		} else if root.Right == nil {
			return root.Left
		}

		temp := FindMin(root.Right)
		root.Data = temp.Data
		root.Right = DeleteNode(root.Right, temp.Data)
	}
	return root
}

func Search(root *Node, data int) bool {
	if root == nil {
		return false
	}

	if data == root.Data {
		return true
	} else if data < root.Data {
		return Search(root.Left, data)
	} else {
		return Search(root.Right, data)
	}
}

func InorderTraversal(root *Node) {
	if root != nil {
		InorderTraversal(root.Left)
		fmt.Printf("%d ", root.Data)
		InorderTraversal(root.Right)
	}
}

func PreorderTraversal(root *Node) {
	if root != nil {
		fmt.Printf("%d ", root.Data)
		PreorderTraversal(root.Left)
		PreorderTraversal(root.Right)
	}
}

func PostorderTraversal(root *Node) {
	if root != nil {
		PostorderTraversal(root.Left)
		PostorderTraversal(root.Right)
		fmt.Printf("%d ", root.Data)
	}
}
