fun main() {
  val heap = SimpleHeap(10)
  heap.insert(3)
  heap.insert(2)
  heap.insert(15)
  heap.insert(5)
  heap.insert(4)
  heap.insert(45)
  heap.printHeap()
  
  println("Minimum element: ${heap.getMin()}")
  println("Extracted min: ${heap.extractMin()}")
  heap.printHeap()
}