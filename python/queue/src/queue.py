class QueueInterface:
    def enqueue(self, item):
        raise NotImplementedError

    def dequeue(self):
        raise NotImplementedError

    def peek(self):
        raise NotImplementedError

    def is_empty(self):
        raise NotImplementedError

    def is_full(self):
        raise NotImplementedError

    def print_queue(self):
        raise NotImplementedError

class Queue(QueueInterface):
    def __init__(self, capacity=5):
        self.items = [None] * capacity
        self.capacity = capacity
        self.size = 0
        self.front = 0
        self.rear = -1

    def enqueue(self, item):
        if self.is_full():
            print("Queue overflow")
            return

        self.rear = (self.rear + 1) % self.capacity
        self.items[self.rear] = item
        self.size += 1

    def dequeue(self):
        if self.is_empty():
            print("Queue underflow")
            return None

        item = self.items[self.front]
        self.items[self.front] = None
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return item

    def peek(self):
        if self.is_empty():
            return None
        return self.items[self.front]

    def is_empty(self):
        return self.size == 0

    def is_full(self):
        return self.size == self.capacity

    def print_queue(self):
        print([self.items[i] for i in range(self.capacity) if self.items[i] is not None])