interface Heap {
    fun insert(value: Int)
    fun extractMin(): Int?
    fun getMin(): Int?
    fun printHeap()
}

class SimpleHeap(private val capacity: Int) : Heap {

    private val arr = ArrayList<Int>(capacity)
    private var size = 0

    override fun insert(value: Int) {
        if (size >= capacity) {
            println("Heap is full")
            return
        }
        arr.add(value)
        size++
        heapifyUp(size - 1)
    }

    override fun extractMin(): Int? {
        if (size <= 0) {
            println("Heap is empty")
            return null
        }
        val min = arr[0]
        arr[0] = arr[size - 1]
        arr.removeAt(size - 1)
        size--
        heapifyDown(0)
        return min
    }

    override fun getMin(): Int? {
        if (size <= 0) {
            println("Heap is empty")
            return null
        }
        return arr[0]
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        while (currentIndex > 0 && arr[parent(currentIndex)] > arr[currentIndex]) {
            swap(currentIndex, parent(currentIndex))
            currentIndex = parent(currentIndex)
        }
    }

    private fun heapifyDown(index: Int) {
        var smallest = index
        val left = left(index)
        val right = right(index)

        if (left < size && arr[left] < arr[smallest]) {
            smallest = left
        }

        if (right < size && arr[right] < arr[smallest]) {
            smallest = right
        }

        if (smallest != index) {
            swap(index, smallest)
            heapifyDown(smallest)
        }
    }

    private fun parent(index: Int): Int = (index - 1) / 2
    private fun left(index: Int): Int = 2 * index + 1
    private fun right(index: Int): Int = 2 * index + 2

    private fun swap(i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    override fun printHeap() {
        print("Min Heap: ")
        for (i in 0 until size) {
            print("${arr[i]} ")
        }
        println()
    }
}