const std = @import("std");

pub const MinHeap = struct {
    heap: []i32,
    size: usize,
    allocator: std.mem.Allocator,

    pub fn init(allocator: std.mem.Allocator, capacity: usize) !MinHeap {
        const heap = try allocator.alloc(i32, capacity);
        return MinHeap{
            .heap = heap,
            .size = 0,
            .allocator = allocator,
        };
    }

    pub fn deinit(self: *MinHeap) void {
        self.allocator.free(self.heap);
    }

    pub fn insert(self: *MinHeap, value: i32) !void {
        if (self.size >= self.heap.len) {
            std.debug.print("Heap is full\n", .{});
            return;
        }

        self.heap[self.size] = value;
        self.heapifyUp(self.size);
        self.size += 1;
    }

    pub fn extractMin(self: *MinHeap) ?i32 {
        if (self.size == 0) {
            std.debug.print("Heap is empty\n", .{});
            return null;
        }

        const min = self.heap[0];
        self.size -= 1;
        if (self.size > 0) {
            self.heap[0] = self.heap[self.size];
            self.heapifyDown(0);
        }
        return min;
    }

    pub fn getMin(self: MinHeap) ?i32 {
        if (self.size == 0) {
            std.debug.print("Heap is empty\n", .{});
            return null;
        }
        return self.heap[0];
    }

    fn heapifyUp(self: *MinHeap, index: usize) void {
        var current = index;
        while (current > 0) {
            const parent = (current - 1) / 2;
            if (self.heap[current] < self.heap[parent]) {
                self.swap(current, parent);
                current = parent;
            } else break;
        }
    }

    fn heapifyDown(self: *MinHeap, index: usize) void {
        var smallest = index;
        const left = 2 * index + 1;
        const right = 2 * index + 2;

        if (left < self.size and self.heap[left] < self.heap[smallest]) {
            smallest = left;
        }

        if (right < self.size and self.heap[right] < self.heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            self.swap(index, smallest);
            self.heapifyDown(smallest);
        }
    }

    fn swap(self: *MinHeap, i: usize, j: usize) void {
        const temp = self.heap[i];
        self.heap[i] = self.heap[j];
        self.heap[j] = temp;
    }

    pub fn printHeap(self: MinHeap) void {
        std.debug.print("Min Heap: ", .{});
        var i: usize = 0;
        while (i < self.size) : (i += 1) {
            std.debug.print("{} ", .{self.heap[i]});
        }
        std.debug.print("\n", .{});
    }
};
