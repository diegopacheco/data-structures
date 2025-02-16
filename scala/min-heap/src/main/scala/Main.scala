object Main {
  def main(args: Array[String]): Unit = {
    val heap = new SimpleHeap(10)
    heap.insert(3)
    heap.insert(2)
    heap.insert(15)
    heap.insert(5)
    heap.insert(4)
    heap.insert(45)
    heap.printHeap()
    
    println(s"Minimum element: ${heap.getMin().get}")
    println(s"Extracted min: ${heap.extractMin().get}")
    heap.printHeap()
  }
}