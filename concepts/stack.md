# Stack

## What is a Stack

A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. Elements are added (push) and removed (pop) from the same end called the top. Think of it like a stack of plates - you can only take the top plate. Stacks are essential for function calls, undo operations, and expression evaluation.

## Pros and Cons

| Pros | Cons |
|------|------|
| O(1) push and pop operations | No random access to elements |
| Simple implementation | Only top element is accessible |
| Memory efficient for LIFO operations | Fixed size in array implementation |
| Natural fit for recursion and backtracking | Not suitable for searching |
| Useful for parsing and expression evaluation | Can overflow if unbounded growth |

## How a Stack Works

```
        PUSH                POP
          |                  |
          v                  v
        +----+            +----+
  TOP ->| 40 |      TOP ->| 30 |  (40 removed)
        +----+            +----+
        | 30 |            | 20 |
        +----+            +----+
        | 20 |            | 10 |
        +----+            +----+
        | 10 |            +----+
        +----+
       BOTTOM            BOTTOM

Operations:
  push(50): Add 50 on TOP
  pop():    Remove 40 from TOP, returns 40
  peek():   Returns 40 without removing
```

## Advanced Stacks

| Structure | Why It's Useful |
|-----------|-----------------|
| Min/Max Stack | O(1) access to minimum or maximum element |
| Two-Stack Queue | Implements queue using two stacks |
| Monotonic Stack | Maintains sorted order for next greater/smaller problems |
| Persistent Stack | Preserves previous versions after modifications |
| Concurrent Stack | Thread-safe lock-free operations |
| Expression Stack | Specialized for infix/postfix expression evaluation |
| Call Stack | Manages function calls and local variables in programs |
