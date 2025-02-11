package main

import "fmt"

type Node struct {
	data int
	next *Node
}

type LinkedList struct {
	head *Node
}

func NewLinkedList() *LinkedList {
	return &LinkedList{nil}
}

func (l *LinkedList) Add(data int) {
	newNode := &Node{data: data}
	if l.head == nil {
		l.head = newNode
		return
	}
	newNode.next = l.head
	l.head = newNode
}

func (l *LinkedList) RemoveValue(value int) bool {
	if l.head == nil {
		return false
	}

	if l.head.data == value {
		l.head = l.head.next
		return true
	}

	current := l.head
	for current.next != nil {
		if current.next.data == value {
			current.next = current.next.next
			return true
		}
		current = current.next
	}
	return false
}

func (l *LinkedList) Contains(value int) bool {
	current := l.head
	for current != nil {
		if current.data == value {
			return true
		}
		current = current.next
	}
	return false
}

func (l *LinkedList) String() string {
	if l.head == nil {
		return "List: []"
	}

	result := "List: "
	current := l.head
	for current != nil {
		result += fmt.Sprintf("%d", current.data)
		if current.next != nil {
			result += " "
		}
		current = current.next
	}
	return result
}
