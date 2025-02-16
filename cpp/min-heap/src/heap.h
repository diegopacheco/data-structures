#ifndef HEAP_H
#define HEAP_H

#include <vector>
#include <iostream>

class MinHeap {
public:
    MinHeap(int capacity);
    ~MinHeap();

    void insert(int value);
    int extractMin();
    int getMin() const;
    void printHeap() const;

private:
    void heapifyUp(int index);
    void heapifyDown(int index);

    std::vector<int> arr;
    int size;
    int capacity;
};

#endif