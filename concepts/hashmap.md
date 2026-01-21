# HashMap

## What is a HashMap

A HashMap is a data structure that stores key-value pairs and provides O(1) average time for insertion, deletion, and lookup. It uses a hash function to compute an index into an array of buckets where the value is stored. When two keys hash to the same index (collision), various strategies handle the conflict. HashMaps are essential for caching, indexing, and fast data retrieval.

## Pros and Cons

| Pros | Cons |
|------|------|
| O(1) average insert, delete, lookup | O(n) worst case with many collisions |
| Flexible key types | Unordered - no natural iteration order |
| Efficient for large datasets | Memory overhead for empty buckets |
| Direct access by key | Hash function quality affects performance |
| Dynamic resizing | Not cache-friendly with chaining |

## How a HashMap Works

```
Key: "apple" -> hash("apple") = 1234567 -> 1234567 % 8 = 7

Buckets (array size 8):
Index:  [0]    [1]    [2]    [3]    [4]    [5]    [6]    [7]
        null   null   "dog"  null   "cat"  null   null   "apple"
                       |             |                     |
                      105           200                   150

put("apple", 150):
  1. Compute hash("apple") = 1234567
  2. Calculate index = 1234567 % 8 = 7
  3. Store value 150 at bucket[7]

get("apple"):
  1. Compute hash("apple") = 1234567
  2. Calculate index = 1234567 % 8 = 7
  3. Return bucket[7] = 150
```

## Hash Function

A hash function converts a key into an integer index. Good hash functions have these properties:
- **Deterministic**: Same input always produces same output
- **Uniform distribution**: Spreads keys evenly across buckets
- **Fast computation**: O(1) time complexity
- **Avalanche effect**: Small input change causes large output change

Common hash functions: MurmurHash, SipHash, FNV-1a, xxHash, CityHash.

## Modulo Operation

The modulo operation maps hash codes to valid bucket indices:
```
index = hash(key) % bucket_count
```
Bucket count is typically a power of 2, allowing bitwise AND optimization:
```
index = hash(key) & (bucket_count - 1)
```

## Closed Addressing (Chaining)

Each bucket contains a linked list (or tree) of entries that hash to the same index.

```
Buckets:
[0] -> null
[1] -> ("cat", 10) -> ("dog", 20) -> null
[2] -> ("bird", 30) -> null
[3] -> null
```

Collisions are handled by appending to the chain. Java's HashMap switches to red-black tree when chain length exceeds 8.

## Open Addressing

All entries are stored directly in the bucket array. On collision, probe for next empty slot.

**Linear Probing**: Check index+1, index+2, index+3...
```
put("cat") at index 5
put("dog") hashes to 5 (collision) -> probe to 6
put("rat") hashes to 5 (collision) -> probe to 6 (full) -> probe to 7

[4]    [5]     [6]    [7]
null   "cat"   "dog"  "rat"
```

**Quadratic Probing**: Check index+1², index+2², index+3²...

**Double Hashing**: Use second hash function for probe step size.

## Concurrency Handling

### Java (ConcurrentHashMap)
- Segment-based locking (Java 7): Divides map into 16 segments, each with its own lock
- CAS + synchronized (Java 8+): Lock-free reads, fine-grained per-bucket locking for writes
- Uses volatile reads and Unsafe/VarHandle for memory visibility

### Rust (std::collections::HashMap)
- Not thread-safe by default
- Use `Arc<Mutex<HashMap>>` or `Arc<RwLock<HashMap>>` for shared access
- `DashMap` crate: Sharded concurrent map with per-shard RwLocks
- Crossbeam's `SkipMap`: Lock-free concurrent ordered map

### Go (sync.Map)
- Two internal maps: read-only (atomic access) and dirty (mutex protected)
- Optimized for read-heavy workloads with stable keys
- Regular map requires explicit `sync.RWMutex` wrapper
- Atomic pointer swaps for promotion from dirty to read map

### Zig (std.HashMap)
- No built-in concurrent hashmap
- Manual synchronization with `std.Thread.Mutex`
- Lock-free patterns possible with `@atomicLoad` and `@atomicStore`
- Often use thread-local hashmaps to avoid contention

## Advanced HashMaps

| Structure | Why It's Useful |
|-----------|-----------------|
| LinkedHashMap | Maintains insertion order with doubly-linked list |
| TreeMap | Sorted keys using red-black tree, O(log n) operations |
| Cuckoo Hashing | Two hash functions, O(1) worst-case lookup |
| Robin Hood Hashing | Reduces probe variance by stealing from rich buckets |
| Swiss Table | SIMD-accelerated probing, used in Abseil and Rust |
| Hopscotch Hashing | Combines chaining and open addressing benefits |
| Consistent Hashing | Minimizes remapping when buckets added/removed, used in distributed systems |
