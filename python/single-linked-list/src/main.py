from list import LinkedList

if __name__ == "__main__":
    list = LinkedList()
    list.insert_at_begin(30)
    list.insert_at_begin(20)
    list.insert_at_begin(10)
    list.insert_at_end(40)
    list.insert_at_end(50)

    print("List:")
    list.print_list()

    list.delete_node(40)
    print("List after deleting 40:")
    list.print_list()

    if list.search_node(4):
        print("4 is in the list")
    else:
        print("4 is not in the list")