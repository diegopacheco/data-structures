class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def insert_at_begin(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def insert_at_end(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = new_node

    def delete_node(self, data):
        current = self.head
        previous = None
        while current:
            if current.data == data:
                if previous:
                    previous.next = current.next
                else:
                    self.head = current.next
                return
            previous = current
            current = current.next

    def search_node(self, data):
        current = self.head
        while current:
            if current.data == data:
                return True
            current = current.next
        return False

    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=" ")
            current = current.next
        print()

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