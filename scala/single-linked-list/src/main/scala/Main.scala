object Main {

  class Node(var data: Int, var next: Node = null)

  class LinkedList {
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
        print(current.data + " ")
        current = current.next
      }
      println()
    }
  }

  def main(args: Array[String]): Unit = {
    val list = new LinkedList()

    list.insertAtBegin(30)
    list.insertAtBegin(20)
    list.insertAtBegin(10)
    list.insertAtEnd(40)
    list.insertAtEnd(50)

    println("List: ")
    list.printList()

    list.deleteNode(40)
    println("List after deleting 40: ")
    list.printList()

    if (list.searchNode(4)) {
      println("4 is in the list")
    } else {
      println("4 is not in the list")
    }
  }
}