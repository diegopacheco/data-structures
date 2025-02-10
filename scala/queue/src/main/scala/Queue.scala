trait Queue[T] {
  def enqueue(item: T): Unit
  def dequeue(): Option[T]
  def peek(): Option[T]
  def isEmpty: Boolean
  def isFull: Boolean
  def printQueue(): Unit
}

object Queue {
  private class ArrayQueue[T](capacity: Int) extends Queue[T] {
    private val items: Array[Any] = new Array[Any](capacity)
    private var front: Int = 0
    private var rear: Int = -1
    private var size: Int = 0

    override def enqueue(item: T): Unit = {
      if (isFull) {
        println("Queue overflow")
      } else {
        rear = (rear + 1) % capacity
        items(rear) = item
        size += 1
      }
    }

    override def dequeue(): Option[T] = {
      if (isEmpty) {
        println("Queue underflow")
        None
      } else {
        val item = items(front).asInstanceOf[T]
        front = (front + 1) % capacity
        size -= 1
        Some(item)
      }
    }

    override def peek(): Option[T] = {
      if (isEmpty) None
      else Some(items(front).asInstanceOf[T])
    }

    override def isEmpty: Boolean = size == 0

    override def isFull: Boolean = size == capacity

    override def printQueue(): Unit = {
      print("Queue: [")
      var i = front
      for (_ <- 0 until size) {
        print(items(i))
        if (i != rear) print(", ")
        i = (i + 1) % capacity
      }
      println("]")
    }
  }

  def apply[T](capacity: Int): Queue[T] = new ArrayQueue[T](capacity)
}