package main

import "fmt"

func main() {
	list := NewLinkedList()

	list.Add(10)
	list.Add(20)
	list.Add(30)
	list.Add(40)
	list.Add(50)

	fmt.Println(list.String())
	list.RemoveValue(40)
	fmt.Println(list.String())

	searchValue := 4
	fmt.Printf("%d %s in the list\n",
		searchValue,
		map[bool]string{true: "found", false: "not found"}[list.Contains(searchValue)])
}
