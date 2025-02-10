fun main() {
  val config = QueueConfig(capacity = 5)
  val queue: Queue<Int> = ArrayQueue(config)

  queue.enqueue(100)
  queue.enqueue(200)
  queue.enqueue(300)
  queue.printQueue()

  println("Peek: ${queue.peek()}")
  println("Dequeue: ${queue.dequeue()}")
  println("Dequeue: ${queue.dequeue()}")

  if (queue.isEmpty()) {
      println("Queue is empty")
  } else {
      println("Queue is not empty")
  }

  queue.printQueue()
}