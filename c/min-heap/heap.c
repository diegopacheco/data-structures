#include <stdio.h>
#include <stdlib.h>
#include "heap.h"

MinHeap* createMinHeap(int capacity) {
    MinHeap* heap = (MinHeap*)malloc(sizeof(MinHeap));
    heap->arr = (int*)malloc(capacity * sizeof(int));
    heap->size = 0;
    heap->capacity = capacity;
    return heap;
}

void destroyMinHeap(MinHeap* heap) {
    free(heap->arr);
    free(heap);
}

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void heapifyUp(MinHeap* heap, int index) {
    int parent = (index - 1) / 2;
    while (index > 0 && heap->arr[parent] > heap->arr[index]) {
        swap(&heap->arr[parent], &heap->arr[index]);
        index = parent;
        parent = (index - 1) / 2;
    }
}

void heapifyDown(MinHeap* heap, int index) {
    int smallest = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if (left < heap->size && heap->arr[left] < heap->arr[smallest])
        smallest = left;

    if (right < heap->size && heap->arr[right] < heap->arr[smallest])
        smallest = right;

    if (smallest != index) {
        swap(&heap->arr[index], &heap->arr[smallest]);
        heapifyDown(heap, smallest);
    }
}

void insert(MinHeap* heap, int value) {
    if (heap->size >= heap->capacity) {
        printf("Heap is full\n");
        return;
    }

    heap->arr[heap->size] = value;
    heapifyUp(heap, heap->size);
    heap->size++;
}

int extractMin(MinHeap* heap) {
    if (heap->size <= 0) {
        printf("Heap is empty\n");
        return -1;
    }

    int min = heap->arr[0];
    heap->arr[0] = heap->arr[heap->size - 1];
    heap->size--;
    heapifyDown(heap, 0);
    return min;
}

int getMin(MinHeap* heap) {
    if (heap->size <= 0) {
        printf("Heap is empty\n");
        return -1;
    }
    return heap->arr[0];
}

void printHeap(MinHeap* heap) {
    printf("Min Heap: ");
    for (int i = 0; i < heap->size; i++) {
        printf("%d ", heap->arr[i]);
    }
    printf("\n");
}