#ifndef HEAP_H
#define HEAP_H

#define MAX_SIZE 100

typedef struct {
    int *arr;
    int size;
    int capacity;
} MinHeap;

MinHeap* createMinHeap(int capacity);
void destroyMinHeap(MinHeap* heap);
void insert(MinHeap* heap, int value);
int extractMin(MinHeap* heap);
int getMin(MinHeap* heap);
void printHeap(MinHeap* heap);

#endif