interface Heap {
    insert(value: number): void;
    extractMin(): number | undefined;
    getMin(): number | undefined;
    printHeap(): void;
}

export class MinHeap implements Heap {
    private heap: number[];
    private size: number;
    private capacity: number;

    constructor(capacity: number) {
        this.heap = new Array(capacity);
        this.size = 0;
        this.capacity = capacity;
    }

    insert(value: number): void {
        if (this.size >= this.capacity) {
            console.log("Heap is full");
            return;
        }

        this.heap[this.size] = value;
        this.heapifyUp(this.size);
        this.size++;
    }

    extractMin(): number | undefined {
        if (this.size <= 0) {
            console.log("Heap is empty");
            return undefined;
        }

        const min = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.size--;
        this.heapifyDown(0);
        return min;
    }

    getMin(): number | undefined {
        if (this.size <= 0) {
            console.log("Heap is empty");
            return undefined;
        }
        return this.heap[0];
    }

    private heapifyUp(index: number): void {
        let currentIndex = index;
        while (currentIndex > 0 && this.heap[this.parent(currentIndex)] > this.heap[currentIndex]) {
            this.swap(currentIndex, this.parent(currentIndex));
            currentIndex = this.parent(currentIndex);
        }
    }

    private heapifyDown(index: number): void {
        let smallest = index;
        const left = this.left(index);
        const right = this.right(index);

        if (left < this.size && this.heap[left] < this.heap[smallest]) {
            smallest = left;
        }

        if (right < this.size && this.heap[right] < this.heap[smallest]) {
            smallest = right;
        }

        if (smallest !== index) {
            this.swap(index, smallest);
            this.heapifyDown(smallest);
        }
    }

    private parent(index: number): number {
        return Math.floor((index - 1) / 2);
    }

    private left(index: number): number {
        return 2 * index + 1;
    }

    private right(index: number): number {
        return 2 * index + 2;
    }

    private swap(i: number, j: number): void {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    printHeap(): void {
        process.stdout.write("Min Heap: ");
        for (let i = 0; i < this.size; i++) {
            process.stdout.write(this.heap[i] + " ");
        }
        console.log();
    }
}