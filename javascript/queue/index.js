import Queue from "./queue.js";

const queue = new Queue(5);

queue.enqueue(100);
queue.enqueue(200);
queue.enqueue(300);

console.log("Peek:", queue.peek());
console.log("Dequeue:", queue.dequeue());
console.log("Dequeue:", queue.dequeue());

if (queue.isEmpty()) {
    console.log("Queue is empty");
} else {
    console.log("Queue is not empty");
}
queue.printQueue();