#include <stdio.h>
#include "heap.h"

int main() {
    MinHeap* heap = createMinHeap(10);
    insert(heap, 3);
    insert(heap, 2);
    insert(heap, 15);
    insert(heap, 5);
    insert(heap, 4);
    insert(heap, 45);
    printHeap(heap);

    printf("Minimum element: %d\n", getMin(heap));
    printf("Extracted min: %d\n", extractMin(heap));
    printHeap(heap);
    
    destroyMinHeap(heap);
    return 0;
}