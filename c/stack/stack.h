#include <stdbool.h>

#ifndef STACK_H
#define STACK_H

#define MAX_SIZE 1024

typedef struct {
    int arr[MAX_SIZE];
    int top;
} Stack;

void initStack(Stack *stack);
bool isEmpty(Stack* stack);
bool isFull(Stack* stack);
void push(Stack* stack, int data);
int pop(Stack* stack);
int peek(Stack* stack);

#endif