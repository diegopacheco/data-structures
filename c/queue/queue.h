#ifndef QUEUE_H
#define QUEUE_H

#include <stdbool.h>

#define MAX_SIZE 1024

typedef struct {
    int items[MAX_SIZE];
    int front;
    int rear;
    int size;
} Queue;

void initQueue(Queue* queue);
bool isEmpty(Queue* queue);
bool isFull(Queue* queue);
void enqueue(Queue* queue, int value);
int dequeue(Queue* queue);
int peek(Queue* queue);
void printQueue(Queue* queue);

#endif