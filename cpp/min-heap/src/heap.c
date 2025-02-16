#include "heap.h"
#include <algorithm>

MinHeap::MinHeap(int capacity) : capacity(capacity), size(0), arr(capacity) {}

MinHeap::~MinHeap() {}

void MinHeap::heapifyUp(int index) {
    int parent = (index - 1) / 2;
    while (index > 0 && arr[parent] > arr[index]) {
        std::swap(arr[parent], arr[index]);
        index = parent;
        parent = (index - 1) / 2;
    }
}

void MinHeap::heapifyDown(int index) {
    int smallest = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if (left < size && arr[left] < arr[smallest])
        smallest = left;

    if (right < size && arr[right] < arr[smallest])
        smallest = right;

    if (smallest != index) {
        std::swap(arr[index], arr[smallest]);
        heapifyDown(smallest);
    }
}

void MinHeap::insert(int value) {
    if (size >= capacity) {
        std::cout << "Heap is full" << std::endl;
        return;
    }

    arr[size] = value;
    heapifyUp(size);
    size++;
}

int MinHeap::extractMin() {
    if (size <= 0) {
        std::cout << "Heap is empty" << std::endl;
        return -1;
    }

    int min = arr[0];
    arr[0] = arr[size - 1];
    size--;
    heapifyDown(0);

    return min;
}

int MinHeap::getMin() const {
    if (size <= 0) {
        std::cout << "Heap is empty" << std::endl;
        return -1;
    }
    return arr[0];
}

void MinHeap::printHeap() const {
    std::cout << "Min Heap: ";
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}