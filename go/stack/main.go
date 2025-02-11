package main

import "fmt"

func main() {
	stack := NewStack()

	stack.Push(100)
	stack.Push(200)
	stack.Push(300)
	fmt.Println(stack.String())

	if top, ok := stack.Top(); ok {
		fmt.Printf("Top: %d\n", top)
	}
	if value, ok := stack.Pop(); ok {
		fmt.Printf("Pop: %d\n", value)
	}
	if value, ok := stack.Pop(); ok {
		fmt.Printf("Pop: %d\n", value)
	}

	fmt.Printf("Stack is %s\n", map[bool]string{true: "empty", false: "not empty"}[stack.IsEmpty()])
	fmt.Println(stack.String())
}
