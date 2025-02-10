object Main {
  def main(args: Array[String]): Unit = {
    val queue = Queue[Int](5)

    queue.enqueue(100)
    queue.enqueue(200)
    queue.enqueue(300)
    queue.printQueue()

    println(s"Peek: ${queue.peek()}")
    println(s"Dequeue: ${queue.dequeue()}")
    println(s"Dequeue: ${queue.dequeue()}")

    if (queue.isEmpty) {
      println("Queue is empty")
    } else {
      println("Queue is not empty")
    }

    queue.printQueue()
  }
}