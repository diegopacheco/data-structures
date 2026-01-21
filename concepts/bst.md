# Binary Search Tree (BST)

## What is a Binary Search Tree

A Binary Search Tree is a hierarchical data structure where each node has at most two children. The left subtree contains nodes with values less than the parent, and the right subtree contains values greater than the parent. This ordering property enables efficient searching, insertion, and deletion. BSTs are fundamental for implementing sorted data collections and search operations.

## Pros and Cons

| Pros | Cons |
|------|------|
| O(log n) average search, insert, delete | Can degenerate to O(n) if unbalanced |
| Maintains sorted order automatically | No O(1) access like arrays |
| Efficient range queries | Extra memory for pointers |
| In-order traversal gives sorted sequence | Balancing requires extra logic |
| Dynamic size - grows as needed | Not cache-friendly due to pointer chasing |

## How a Binary Search Tree Works

```
                    50 (root)
                   /  \
                 30    70
                /  \   /  \
              20   40 60   80
             /              \
           10               90

Insert 25:
  - 25 < 50, go left
  - 25 < 30, go left
  - 25 > 20, go right -> insert as right child of 20

Search 60:
  - 60 > 50, go right
  - 60 < 70, go left
  - Found 60!

Property: left < parent < right (always)
```

## Advanced Trees

| Structure | Why It's Useful |
|-----------|-----------------|
| AVL Tree | Self-balancing with strict height difference of 1, guarantees O(log n) |
| Red-Black Tree | Self-balancing with relaxed rules, faster insertions than AVL |
| B-Tree | Multiple keys per node, optimized for disk-based storage |
| B+ Tree | All data in leaves, excellent for database indexes and range queries |
| Splay Tree | Self-adjusting, recently accessed elements move to root |
| Treap | Combines BST and heap properties using random priorities |
| Trie | Prefix tree for efficient string operations and autocomplete |
