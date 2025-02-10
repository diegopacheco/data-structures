trait Stack[T] {
  def push(elem: T): Unit
  def pop(): Option[T]
  def peek(): Option[T]
  def isEmpty: Boolean
  def isFull: Boolean
  def printStack(): Unit
}

object Stack {
  private class ArrayStack[T](capacity: Int) extends Stack[T] {
    private val items: Array[Any] = new Array[Any](capacity)
    private var top: Int = -1

    override def push(elem: T): Unit = {
      if (isFull) {
        println("Stack overflow")
      } else {
        top += 1
        items(top) = elem
      }
    }

    override def pop(): Option[T] = {
      if (isEmpty) {
        println("Stack underflow")
        None
      } else {
        val elem = items(top).asInstanceOf[T]
        top -= 1
        Some(elem)
      }
    }

    override def peek(): Option[T] = {
      if (isEmpty) None
      else Some(items(top).asInstanceOf[T])
    }

    override def isEmpty: Boolean = top == -1

    override def isFull: Boolean = top == items.length - 1

    override def printStack(): Unit = {
      for (i <- 0 to top) {
        print(s"${items(i)} ")
      }
      println()
    }

  }

  def apply[T](capacity: Int): Stack[T] = new ArrayStack[T](capacity)
}