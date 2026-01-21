# Linked List

## What is a Linked List

A linked list is a linear data structure where elements are stored in nodes. Each node contains data and a reference (pointer) to the next node in the sequence. Unlike arrays, linked lists do not store elements in contiguous memory locations. The first node is called the head, and the last node points to null.

## Pros and Cons

| Pros | Cons |
|------|------|
| Dynamic size - grows/shrinks at runtime | No random access - must traverse from head |
| Efficient insertion/deletion at beginning O(1) | Extra memory for storing pointers |
| No memory waste from pre-allocation | Poor cache locality |
| Easy to implement stacks and queues | Reverse traversal is difficult |
| No need to define initial size | Search operation is O(n) |

## How a Linked List Works

```
  HEAD
   |
   v
+------+    +------+    +------+    +------+
| data |    | data |    | data |    | data |
|  10  | -> |  20  | -> |  30  | -> |  40  | -> NULL
+------+    +------+    +------+    +------+
  Node 1      Node 2      Node 3      Node 4
```

Each node stores a value and a pointer to the next node. Traversal starts from HEAD and follows pointers until NULL is reached.

## Advanced Lists

| Structure | Why It's Useful |
|-----------|-----------------|
| Doubly Linked List | Allows traversal in both directions using prev/next pointers |
| Circular Linked List | Last node points to head, useful for round-robin scheduling |
| Circular Doubly Linked List | Combines circular and doubly linked features for bidirectional cycling |
| Skip List | Provides O(log n) search by maintaining multiple levels of linked lists |
| Unrolled Linked List | Stores multiple elements per node, improving cache performance |
| XOR Linked List | Uses XOR of addresses to save memory while allowing bidirectional traversal |
| Self-Organizing List | Reorders nodes based on access frequency for faster repeated lookups |
