package main

import "fmt"

func main() {
	queue := NewQueue()
	queue.Enqueue(100)
	queue.Enqueue(200)
	queue.Enqueue(300)

	fmt.Println(queue.String())
	if front, ok := queue.Front(); ok {
		fmt.Printf("Front element: %d\n", front)
	}
	if value, ok := queue.Dequeue(); ok {
		fmt.Printf("Dequeued: %d\n", value)
	}
	if value, ok := queue.Dequeue(); ok {
		fmt.Printf("Dequeued: %d\n", value)
	}

	fmt.Printf("Queue is %s\n", map[bool]string{true: "empty", false: "not empty"}[queue.IsEmpty()])
	fmt.Println(queue.String())
}
