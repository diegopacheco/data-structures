package main

import (
	"fmt"
	"hash/fnv"
)

// should be bigger and prime
// but I did less for testing
const tableSize = 10

type Node struct {
	key   string
	value interface{}
	next  *Node
}

type HashTable struct {
	table [tableSize]*Node
}

func NewHashTable() *HashTable {
	return &HashTable{}
}

func (ht *HashTable) hash(key string) uint32 {
	h := fnv.New32a()
	h.Write([]byte(key))
	return h.Sum32() % tableSize
}

func (ht *HashTable) Put(key string, value interface{}) {
	index := ht.hash(key)
	if ht.table[index] == nil {
		ht.table[index] = &Node{key: key, value: value}
		return
	}

	current := ht.table[index]
	for current != nil {
		if current.key == key {
			current.value = value
			return
		}
		if current.next == nil {
			current.next = &Node{key: key, value: value}
			return
		}
		current = current.next
	}
}

func (ht *HashTable) Get(key string) (interface{}, bool) {
	index := ht.hash(key)
	current := ht.table[index]

	for current != nil {
		if current.key == key {
			return current.value, true
		}
		current = current.next
	}
	return nil, false
}

func (ht *HashTable) Remove(key string) bool {
	index := ht.hash(key)
	if ht.table[index] == nil {
		return false
	}

	if ht.table[index].key == key {
		ht.table[index] = ht.table[index].next
		return true
	}

	current := ht.table[index]
	for current.next != nil {
		if current.next.key == key {
			current.next = current.next.next
			return true
		}
		current = current.next
	}
	return false
}

func (ht *HashTable) String() string {
	result := ""
	for i := 0; i < tableSize; i++ {
		result += fmt.Sprintf("Bucket[%d]: ", i)
		current := ht.table[i]
		for current != nil {
			result += fmt.Sprintf("(%s:%v) ", current.key, current.value)
			current = current.next
		}
		result += "\n"
	}
	return result
}
