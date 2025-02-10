#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "stack.h"

void initStack(Stack *stack){
    stack->top = -1;
}

bool isEmpty(Stack* stack){
    return stack->top == MAX_SIZE - 1;
}

bool isFull(Stack* stack){
    return MAX_SIZE - 1 == stack->top;
}

void push(Stack* stack, int data){
    if (isFull(stack)){
        fprintf(stderr, "Stack is full\n");
        return;
    }
    stack->arr[++stack->top] = data;
}

int pop(Stack* stack){
    if (isEmpty(stack)){
        fprintf(stderr, "Stack is empty\n");
        return -1;
    }
    return stack->arr[stack->top--];
}

int peek(Stack* stack){
    if (isEmpty(stack)){
        fprintf(stderr, "Stack is empty\n");
        return -1;
    }
    return stack->arr[stack->top];
}

void printStack(Stack* stack){
    if (isEmpty(stack)){
        fprintf(stdout, "Stack is empty\n");
        return;
    }
    for (int i = 0; i <= stack->top; i++){
        fprintf(stdout, "%d ", stack->arr[i]);
    }
    fprintf(stdout, "\n");
}
