interface Stack<T> {
    push(item: T): void;
    pop(): T | undefined;
    peek(): T | undefined;
    isEmpty(): boolean;
    isFull(): boolean;
    printStack(): void;
}

class SimpleStack<T> implements Stack<T> {
    private readonly capacity: number;
    private items: T[] = [];

    constructor(capacity: number = 5) {
        this.capacity = capacity;
    }

    push(item: T): void {
        if (this.isFull()) {
            console.log("Stack Overflow");
            return;
        }
        this.items.push(item);
    }

    pop(): T | undefined {
        if (this.isEmpty()) {
            console.log("Stack Underflow");
            return undefined;
        }
        return this.items.pop();
    }

    peek(): T | undefined {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.items[this.items.length - 1];
    }

    isEmpty(): boolean {
        return this.items.length === 0;
    }

    isFull(): boolean {
        return this.items.length === this.capacity;
    }

    printStack(): void {
        console.log(this.items);
    }
}

export default SimpleStack;