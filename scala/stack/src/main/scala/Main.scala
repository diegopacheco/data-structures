object Main {
  def main(args: Array[String]): Unit = {
    val stack = Stack[Int](5)

    stack.push(100)
    stack.push(200)
    stack.push(300)
    stack.printStack()

    println(s"Top element: ${stack.peek()}")
    println(s"Pop: ${stack.pop()}")
    println(s"Pop: ${stack.pop()}")

    if (stack.isEmpty) {
      println("Stack is empty")
    } else {
      println("Stack is not empty")
    }
    stack.printStack()
  }
}