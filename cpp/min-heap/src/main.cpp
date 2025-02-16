#include "heap.h"

int main() {
    MinHeap heap(10);
    heap.insert(3);
    heap.insert(2);
    heap.insert(15);
    heap.insert(5);
    heap.insert(4);
    heap.insert(45);
    heap.printHeap();

    std::cout << "Minimum element: " << heap.getMin() << std::endl;
    std::cout << "Extracted min: " << heap.extractMin() << std::endl;
    heap.printHeap();

    return 0;
}