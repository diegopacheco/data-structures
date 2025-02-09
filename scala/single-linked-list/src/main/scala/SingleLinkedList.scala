object SingleLinkedList {
  case class Node(var data: Int, var next: Node = null)

  class SingleLinkedList {
    var head: Node = null

    def insertAtBegin(data: Int): Unit = {
      val newNode = new Node(data)
      newNode.next = head
      head = newNode
    }

    def insertAtEnd(data: Int): Unit = {
      val newNode = new Node(data)
      if (head == null) {
        head = newNode
      } else {
        var current = head
        while (current.next != null) {
          current = current.next
        }
        current.next = newNode
      }
    }

    def deleteNode(data: Int): Unit = {
      if (head == null) return
      if (head.data == data) {
        head = head.next
        return
      }

      var current = head
      while (current.next != null && current.next.data != data) {
        current = current.next
      }
      if (current.next != null) {
        current.next = current.next.next
      }
    }

    def searchNode(data: Int): Boolean = {
      var current = head
      while (current != null) {
        if (current.data == data) {
          return true
        }
        current = current.next
      }
      false
    }

    def printList(): Unit = {
      var current = head
      while (current != null) {
        print(s"${current.data} ")
        current = current.next
      }
      println()
    }
  }
}