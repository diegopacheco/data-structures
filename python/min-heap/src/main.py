from heap import MinHeap

heap = MinHeap()
heap.insert(3)
heap.insert(2)
heap.insert(15)
heap.insert(5)
heap.insert(4)
heap.insert(45)
heap.print_heap()

print("Minimum element:", heap.get_min())
print("Extracted min:", heap.extract_min())
heap.print_heap()
