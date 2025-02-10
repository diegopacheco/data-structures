#ifndef STACK_H
#define STACK_H

#include <stdbool.h>

#define MAX_SIZE 5

typedef struct {
    int data[MAX_SIZE];
    int top;
} Stack;

void initStack(Stack* stack);
bool isEmpty(Stack* stack);
bool isFull(Stack* stack);
void push(Stack* stack, int value);
int pop(Stack* stack);
int peek(Stack* stack);
void printStack(Stack* stack);

#endif