trait Heap {
  def insert(value: Int): Unit
  def extractMin(): Option[Int]
  def getMin(): Option[Int]
  def printHeap(): Unit
}

class SimpleHeap(capacity: Int) extends Heap {
  private val arr: Array[Int] = new Array[Int](capacity)
  private var size: Int = 0

  override def insert(value: Int): Unit = {
    if (size >= capacity) {
      println("Heap is full")
      return
    }
    arr(size) = value
    size += 1
    heapifyUp(size - 1)
  }

  override def extractMin(): Option[Int] = {
    if (size <= 0) {
      println("Heap is empty")
      return None
    }
    val min = arr(0)
    arr(0) = arr(size - 1)
    size -= 1
    heapifyDown(0)
    Some(min)
  }

  override def getMin(): Option[Int] = {
    if (size <= 0) {
      println("Heap is empty")
      return None
    }
    Some(arr(0))
  }

  private def heapifyUp(index: Int): Unit = {
    var currentIndex = index
    while (currentIndex > 0 && arr(parent(currentIndex)) > arr(currentIndex)) {
      swap(currentIndex, parent(currentIndex))
      currentIndex = parent(currentIndex)
    }
  }

  private def heapifyDown(index: Int): Unit = {
    var currentIndex = index
    while (true) {
      val leftIndex = left(currentIndex)
      val rightIndex = right(currentIndex)
      var smallest = currentIndex

      if (leftIndex < size && arr(leftIndex) < arr(smallest)) {
        smallest = leftIndex
      }

      if (rightIndex < size && arr(rightIndex) < arr(smallest)) {
        smallest = rightIndex
      }

      if (smallest != currentIndex) {
        swap(currentIndex, smallest)
        currentIndex = smallest
      } else {
        return
      }
    }
  }

  private def parent(index: Int): Int = (index - 1) / 2
  private def left(index: Int): Int = 2 * index + 1
  private def right(index: Int): Int = 2 * index + 2

  private def swap(i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  override def printHeap(): Unit = {
    print("Min Heap: ")
    for (i <- 0 until size) {
      print(s"${arr(i)} ")
    }
    println()
  }
}