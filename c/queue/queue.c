#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

void initQueue(Queue* queue) {
    queue->front = 0;
    queue->rear = -1;
    queue->size = 0;
}

bool isEmpty(Queue* queue) {
    return queue->size == 0;
}

bool isFull(Queue* queue) {
    return queue->size == MAX_SIZE;
}

void enqueue(Queue* queue, int value) {
    if (isFull(queue)) {
        printf("Queue overflow\n");
        return;
    }
    queue->rear = (queue->rear + 1) % MAX_SIZE;
    queue->items[queue->rear] = value;
    queue->size++;
}

int dequeue(Queue* queue) {
    if (isEmpty(queue)) {
        printf("Queue underflow\n");
        return -1;
    }
    int value = queue->items[queue->front];
    queue->front = (queue->front + 1) % MAX_SIZE;
    queue->size--;
    return value;
}

int peek(Queue* queue) {
    if (isEmpty(queue)) {
        printf("Queue is empty\n");
        return -1;
    }
    return queue->items[queue->front];
}

void printQueue(Queue* queue) {
    if (isEmpty(queue)) {
        printf("Queue: []\n");
        return;
    }

    printf("Queue: [");
    int count = 0;
    int index = queue->front;
    
    while (count < queue->size) {
        printf("%d", queue->items[index]);
        if (count < queue->size - 1) {
            printf(", ");
        }
        index = (index + 1) % MAX_SIZE;
        count++;
    }
    printf("]\n");
}