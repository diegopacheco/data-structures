class Stack<T>(private val capacity: Int = 5) {
    private val items = mutableListOf<T>()

    fun isEmpty() = items.isEmpty()
    fun isFull() = items.size == capacity

    fun push(value: T) {
        if (isFull()) {
            println("Stack overflow.")
        } else {
            items.add(value)
        }
    }

    fun pop(): T? {
        if (isEmpty()) {
            println("Stack underflow.")
            return null
        }
        return items.removeAt(items.lastIndex)
    }

    fun peek(): T? {
        return if (isEmpty()) null else items.last()
    }

    fun printStack(): Unit {
        items.forEach { println(it) }
    }
}