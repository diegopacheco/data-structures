#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 1024;

typedef struct {
    int arr[MAX_SIZE];
    int top;
} Stack;

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

int main(){
    Stack s;
    initStack(&s);

    push(&s, 100);
    push(&s, 200);
    push(&s, 300);
    fprintf(stdout, "Top: %d\n", peek(&s));
    fprintf(stdout, "Pop: %d\n", pop(&s));
    fprintf(stdout, "Pop: %d\n", pop(&s));

    if (isEmpty(&s)){
        fprintf(stdout, "Stack is empty\n");
    } else {
        fprintf(stdout, "Stack is not empty\n");
    }
    return 0;
}