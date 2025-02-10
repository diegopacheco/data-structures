#include "stack.h"
#include <iostream>

int main() {
    Stack s;
    initStack(&s);

    push(&s, 10);
    push(&s, 20);
    push(&s, 30);
    printStack(&s);
    std::cout << "Top element: " << peek(&s) << std::endl;

    std::cout << "Pop: " << pop(&s) << std::endl;
    std::cout << "Pop: " << pop(&s) << std::endl;

    if (isEmpty(&s)) {
        std::cout << "Stack is now empty.\n";
    }
    printStack(&s);
    return 0;
}