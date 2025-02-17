import { MinHeap } from './heap.ts';

const heap = new MinHeap(10);
heap.insert(3);
heap.insert(2);
heap.insert(15);
heap.insert(5);
heap.insert(4);
heap.insert(45);
heap.printHeap();

console.log("Minimum element:", heap.getMin());
console.log("Extracted min:", heap.extractMin());
heap.printHeap();