interface Queue<T> {
    enqueue(item: T): void;
    dequeue(): T | undefined;
    peek(): T | undefined;
    isEmpty(): boolean;
    isFull(): boolean;
    printQueue(): void;
}

class SimpleQueue<T> implements Queue<T> {
    private readonly capacity: number;
    private items: T[] = [];

    constructor(capacity: number = 5) {
        this.capacity = capacity;
    }

    enqueue(item: T): void {
        if (this.isFull()) {
            console.log("Queue overflow");
            return;
        }
        this.items.push(item);
    }

    dequeue(): T | undefined {
        if (this.isEmpty()) {
            console.log("Queue underflow");
            return undefined;
        }
        return this.items.shift();
    }

    peek(): T | undefined {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.items[0];
    }

    isEmpty(): boolean {
        return this.items.length === 0;
    }

    isFull(): boolean {
        return this.items.length >= this.capacity;
    }

    printQueue(): void {
        console.log(this.items);
    }
}

export default SimpleQueue;