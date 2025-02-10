#include "stack.h"
#include <iostream>

void initStack(Stack* stack) {
    stack->top = -1;
}

bool isEmpty(Stack* stack) {
    return stack->top == -1;
}

bool isFull(Stack* stack) {
    return MAX_SIZE - 1 == stack->top;
}

void push(Stack* stack, int value) {
    if (isFull(stack)) {
        std::cout << "Stack overflow.\n";
        return;
    }
    stack->data[++stack->top] = value;
}

int pop(Stack* stack) {
    if (isEmpty(stack)) {
        std::cout << "Stack underflow.\n";
        return -1;
    }
    return stack->data[stack->top--];
}

int peek(Stack* stack) {
    if (isEmpty(stack)) {
        std::cout << "Stack is empty.\n";
        return -1;
    }
    return stack->data[stack->top];
}

void printStack(Stack* stack) {
    if (isEmpty(stack)) {
        std::cout << "Stack is empty.\n";
        return;
    }
    std::cout << "Stack: ";
    for (int i = 0; i <= stack->top; i++) {
        std::cout << stack->data[i] << " ";
    }
    std::cout << std::endl;
}