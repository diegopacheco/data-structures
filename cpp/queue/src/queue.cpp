#include "queue.h"
#include <iostream>

template<typename T>
requires std::movable<T>
Queue<T>::Queue(size_t max_size) : capacity(max_size) {
    items.reserve(capacity);
}

template<typename T>
requires std::movable<T>
void Queue<T>::enqueue(T value) {
    if (isFull()) {
        std::cout << "Queue overflow\n";
        return;
    }
    items.push_back(std::move(value));
}

template<typename T>
requires std::movable<T>
std::optional<T> Queue<T>::dequeue() {
    if (isEmpty()) {
        std::cout << "Queue underflow\n";
        return std::nullopt;
    }
    T value = std::move(items.front());
    items.erase(items.begin());
    return value;
}

template<typename T>
requires std::movable<T>
std::optional<T> Queue<T>::peek() const {
    if (isEmpty()) {
        std::cout << "Queue is empty\n";
        return std::nullopt;
    }
    return items.front();
}

template<typename T>
requires std::movable<T>
bool Queue<T>::isEmpty() const {
    return items.empty();
}

template<typename T>
requires std::movable<T>
bool Queue<T>::isFull() const {
    return items.size() >= capacity;
}

template<typename T>
requires std::movable<T>
void Queue<T>::printQueue() const {
    std::cout << "Queue: [";
    for (size_t i = 0; i < items.size(); ++i) {
        std::cout << items[i];
        if (i < items.size() - 1) std::cout << ", ";
    }
    std::cout << "]\n";
}

template class Queue<int>;
template class Queue<double>;
template class Queue<std::string>;