class Stack:
    def __init__(self, capacity=5):
        self.items = []
        self.capacity = capacity

    def is_empty(self):
        return len(self.items) == 0

    def is_full(self):
        return len(self.items) == self.capacity

    def push(self, data):
        if self.is_full():
            print("Stack overflow.")
        else:
            self.items.append(data)

    def pop(self):
        if self.is_empty():
            print("Stack underflow.")
            return None
        return self.items.pop()

    def peek(self):
        if self.is_empty():
            return None
        return self.items[-1]
    
    def print_stack(self):
        print("Stack:")
        for item in self.items:
            print(item, end=" ")
        print()