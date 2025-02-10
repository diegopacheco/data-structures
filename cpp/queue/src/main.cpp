#include "queue.h"
#include <iostream>

int main() {
    Queue<int> q(5);
    
    q.enqueue(100);
    q.enqueue(200);
    q.enqueue(300);
    q.printQueue();
    
    if (auto front = q.peek(); front) {
        std::cout << "Front element: " << *front << '\n';
    }
    if (auto value = q.dequeue(); value) {
        std::cout << "Dequeued: " << *value << '\n';
    }
    if (auto value = q.dequeue(); value) {
        std::cout << "Dequeued: " << *value << '\n';
    }
    
    std::cout << (q.isEmpty() ? "Queue is empty\n" : "Queue is not empty\n");
    q.printQueue();
    return 0;
}