#include <stdio.h>
#include "queue.h"

int main() {
    Queue q;
    initQueue(&q);
    enqueue(&q, 100);
    enqueue(&q, 200);
    enqueue(&q, 300);

    printQueue(&q);
    printf("Front element: %d\n", peek(&q));
    printf("Dequeue: %d\n", dequeue(&q));
    printf("Dequeue: %d\n", dequeue(&q));

    if (isEmpty(&q)) {
        printf("Queue is empty\n");
    } else {
        printf("Queue is not empty\n");
    }

    printQueue(&q);
    return 0;
}