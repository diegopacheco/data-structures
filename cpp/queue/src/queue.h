#ifndef QUEUE_H
#define QUEUE_H

#include <optional>
#include <vector>
#include <type_traits>

template<typename T>
requires std::is_move_constructible<T>::value
class Queue {
private:
    std::vector<T> items;
    size_t capacity;

public:
    explicit Queue(size_t max_size = 5);
    
    void enqueue(T value);
    std::optional<T> dequeue();
    std::optional<T> peek() const;
    
    [[nodiscard]] bool isEmpty() const;
    [[nodiscard]] bool isFull() const;
    void printQueue() const;

    ~Queue() = default;
    Queue(const Queue&) = default;
    Queue& operator=(const Queue&) = default;
    Queue(Queue&&) noexcept = default;
    Queue& operator=(Queue&&) noexcept = default;
};

#endif