fun main() {
  val stack = Stack<Int>(5)
  stack.push(100)
  stack.push(200)
  stack.push(300)
  stack.printStack();
  println("Top element: ${stack.peek()}")
  println("Pop: ${stack.pop()}")
  println("Pop: ${stack.pop()}")

  if (stack.isEmpty()) {
      println("Stack is empty.")
  } else {
      println("Stack is not empty.")
  }
  stack.printStack();
}