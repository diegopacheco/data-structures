class Queue {
    constructor(capacity = 5) {
        this.items = [];
        this.capacity = capacity;
    }

    enqueue(item) {
        if (this.isFull()) {
            console.log("Queue overflow");
            return;
        }
        this.items.push(item);
    }

    dequeue() {
        if (this.isEmpty()) {
            console.log("Queue underflow");
            return undefined;
        }
        return this.items.shift();
    }

    peek() {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.items[0];
    }

    isEmpty() {
        return this.items.length === 0;
    }

    isFull() {
        return this.items.length === this.capacity;
    }

    printQueue() {
        console.log(this.items);
    }
}

export default Queue;