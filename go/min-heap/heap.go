package main

import "fmt"

type MinHeap struct {
	array []int
	size  int
}

func NewMinHeap(capacity int) *MinHeap {
	return &MinHeap{
		array: make([]int, 0, capacity),
		size:  0,
	}
}

func (h *MinHeap) insert(value int) {
	h.array = append(h.array, value)
	h.size++
	h.heapifyUp(h.size - 1)
}

func (h *MinHeap) extractMin() int {
	if h.size == 0 {
		fmt.Println("Heap is empty")
		return -1
	}
	min := h.array[0]
	h.array[0] = h.array[h.size-1]
	h.array = h.array[:h.size-1]
	h.size--
	h.heapifyDown(0)
	return min
}

func (h *MinHeap) getMin() int {
	if h.size == 0 {
		fmt.Println("Heap is empty")
		return -1
	}
	return h.array[0]
}

func (h *MinHeap) heapifyUp(index int) {
	for index > 0 && h.array[(index-1)/2] > h.array[index] {
		h.swap((index-1)/2, index)
		index = (index - 1) / 2
	}
}

func (h *MinHeap) heapifyDown(index int) {
	smallest := index
	left := 2*index + 1
	right := 2*index + 2

	if left < h.size && h.array[left] < h.array[smallest] {
		smallest = left
	}

	if right < h.size && h.array[right] < h.array[smallest] {
		smallest = right
	}

	if smallest != index {
		h.swap(index, smallest)
		h.heapifyDown(smallest)
	}
}

func (h *MinHeap) swap(i, j int) {
	h.array[i], h.array[j] = h.array[j], h.array[i]
}

func (h *MinHeap) printHeap() {
	fmt.Print("Min Heap: ")
	for i := 0; i < h.size; i++ {
		fmt.Printf("%d ", h.array[i])
	}
	fmt.Println()
}
