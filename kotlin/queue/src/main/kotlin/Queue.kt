interface Queue<T> {
    fun enqueue(item: T)
    fun dequeue(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
    fun isFull(): Boolean
    fun printQueue()
}

data class QueueConfig(val capacity: Int = 5)

class ArrayQueue<T>(config: QueueConfig) : Queue<T> {

    private val capacity = config.capacity
    private val items: MutableList<T> = mutableListOf()

    override fun enqueue(item: T) {
        if (isFull()) {
            println("Queue is full. Cannot enqueue $item")
            return
        }
        items.add(item)
    }

    override fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue is empty. Cannot dequeue.")
            return null
        }
        return items.removeAt(0)
    }

    override fun peek(): T? {
        return items.firstOrNull()
    }

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    override fun isFull(): Boolean {
        return items.size >= capacity
    }

    override fun printQueue() {
        println("Queue: $items")
    }
}