class MinHeap:
    def __init__(self):
        self.heap = []

    def insert(self, value):
        self.heap.append(value)
        self._heapify_up()

    def extract_min(self):
        if not self.heap:
            print("Heap is empty")
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        min_val = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down()
        return min_val

    def get_min(self):
        if not self.heap:
            print("Heap is empty")
            return None
        return self.heap[0]

    def _heapify_up(self):
        current_index = len(self.heap) - 1

        while current_index > 0 and self.heap[current_index] < self.heap[self._parent(current_index)]:
            self._swap(current_index, self._parent(current_index))
            current_index = self._parent(current_index)

    def _heapify_down(self):
        current_index = 0

        while True:
            left_index = self._left_child(current_index)
            right_index = self._right_child(current_index)
            smallest = current_index

            if left_index < len(self.heap) and self.heap[left_index] < self.heap[smallest]:
                smallest = left_index

            if right_index < len(self.heap) and self.heap[right_index] < self.heap[smallest]:
                smallest = right_index

            if smallest != current_index:
                self._swap(current_index, smallest)
                current_index = smallest
            else:
                break

    def _parent(self, index):
        return (index - 1) // 2

    def _left_child(self, index):
        return 2 * index + 1

    def _right_child(self, index):
        return 2 * index + 2

    def _swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def print_heap(self):
        print("Min Heap:", ' '.join(map(str, self.heap)))