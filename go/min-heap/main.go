package main

import "fmt"

func main() {
	heap := NewMinHeap(10)
	heap.insert(3)
	heap.insert(2)
	heap.insert(15)
	heap.insert(5)
	heap.insert(4)
	heap.insert(45)

	heap.printHeap()
	fmt.Println("Minimum element:", heap.getMin())
	fmt.Println("Extracted min:", heap.extractMin())
	heap.printHeap()
}
