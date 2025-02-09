import LinkedList;

object Main {

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