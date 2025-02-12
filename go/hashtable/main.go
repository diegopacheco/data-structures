package main

import "fmt"

func main() {
	ht := NewHashTable()

	ht.Put("one", 100)
	ht.Put("two", 200)
	ht.Put("three", 300)

	fmt.Println("Initial HashTable:")
	fmt.Print(ht)

	if value, found := ht.Get("two"); found {
		fmt.Printf("\nValue for key 'two': %v\n", value)
	}

	fmt.Println("\nRemoving key 'two'...")
	ht.Remove("two")

	fmt.Println("\nHashTable after removal:")
	fmt.Print(ht)
}
