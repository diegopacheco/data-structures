package main

import "fmt"

type Queue struct {
	items []int
}

func NewQueue() *Queue {
	return &Queue{
		items: make([]int, 0),
	}
}

func (q *Queue) Enqueue(value int) {
	q.items = append(q.items, value)
}

func (q *Queue) Dequeue() (int, bool) {
	if q.IsEmpty() {
		return 0, false
	}
	value := q.items[0]
	q.items = q.items[1:]
	return value, true
}

func (q *Queue) Front() (int, bool) {
	if q.IsEmpty() {
		return 0, false
	}
	return q.items[0], true
}

func (q *Queue) IsEmpty() bool {
	return len(q.items) == 0
}

func (q *Queue) String() string {
	if q.IsEmpty() {
		return "Queue: []"
	}
	return fmt.Sprintf("Queue: %v", q.items)
}
