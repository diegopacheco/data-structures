package main

import "fmt"

type Stack struct {
	items []int
}

func NewStack() *Stack {
	return &Stack{
		items: make([]int, 0),
	}
}

func (s *Stack) Push(value int) {
	s.items = append(s.items, value)
}

func (s *Stack) Pop() (int, bool) {
	if s.IsEmpty() {
		return 0, false
	}
	n := len(s.items)
	value := s.items[n-1]
	s.items = s.items[:n-1]
	return value, true
}

func (s *Stack) Top() (int, bool) {
	if s.IsEmpty() {
		return 0, false
	}
	return s.items[len(s.items)-1], true
}

func (s *Stack) IsEmpty() bool {
	return len(s.items) == 0
}

func (s *Stack) String() string {
	if s.IsEmpty() {
		return ""
	}
	result := ""
	for i := len(s.items) - 1; i >= 0; i-- {
		result += fmt.Sprintf("%d", s.items[i])
		if i > 0 {
			result += " "
		}
	}
	return result
}
