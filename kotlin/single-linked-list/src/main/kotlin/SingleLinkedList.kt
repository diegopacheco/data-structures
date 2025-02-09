class Node<T>(var data: T, var next: Node<T>? = null)

class LinkedList<T> {
  var head: Node<T>? = null

  fun insertAtBegin(data: T) {
    val newNode = Node(data)
    newNode.next = head
    head = newNode
  }

  fun insertAtEnd(data: T) {
    val newNode = Node(data)
    if (head == null) {
      head = newNode
    } else {
      var current = head
      while (current?.next != null) {
        current = current.next
      }
      current?.next = newNode
    }
  }

  fun deleteNode(data: T) {
    if (head == null) return

    if (head?.data == data) {
      head = head?.next
      return
    }

    var current = head
    while (current?.next != null && current.next?.data != data) {
      current = current.next
    }

    if (current?.next != null) {
      current.next = current.next?.next
    }
  }

  fun searchNode(data: T): Boolean {
    var current = head
    while (current != null) {
      if (current.data == data) {
        return true
      }
      current = current.next
    }
    return false
  }

  fun printList() {
    var current = head
    while (current != null) {
      print("${current.data} ")
      current = current.next
    }
    println()
  }
}
