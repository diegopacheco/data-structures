# Queue

## What is a Queue

A queue is a linear data structure that follows the First-In-First-Out (FIFO) principle. Elements are added at the rear (enqueue) and removed from the front (dequeue). Think of it like a line of people waiting - the first person to arrive is the first to be served. Queues are fundamental for task scheduling and buffering operations.

## Pros and Cons

| Pros | Cons |
|------|------|
| Maintains order of insertion | No random access to elements |
| O(1) enqueue and dequeue operations | Searching requires O(n) time |
| Fair processing - first come first served | Fixed size in array implementation |
| Useful for BFS and scheduling algorithms | Memory overhead in linked implementation |
| Simple and intuitive to understand | Middle element access is inefficient |

## How a Queue Works

```
  FRONT                                    REAR
    |                                        |
    v                                        v
+------+    +------+    +------+    +------+
|  10  | <- |  20  | <- |  30  | <- |  40  |
+------+    +------+    +------+    +------+

DEQUEUE <--                          <-- ENQUEUE
(remove)                                (add)

Operations:
  enqueue(50): Add 50 at REAR
  dequeue():   Remove 10 from FRONT, returns 10
```

## Advanced Queues

| Structure | Why It's Useful |
|-----------|-----------------|
| Circular Queue | Reuses empty spaces at front, efficient memory usage |
| Priority Queue | Elements dequeued by priority not arrival order |
| Double-Ended Queue (Deque) | Insert/remove from both ends |
| Blocking Queue | Thread-safe, blocks when empty or full |
| Concurrent Queue | Lock-free thread-safe operations for parallel processing |
| Monotonic Queue | Maintains elements in sorted order for sliding window problems |
| Delay Queue | Elements available only after a specified delay |
