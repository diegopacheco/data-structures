const std = @import("std");
const heap = @import("heap.zig");

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();

    var min_heap = try heap.MinHeap.init(allocator, 10);
    defer min_heap.deinit();

    try min_heap.insert(3);
    try min_heap.insert(2);
    try min_heap.insert(15);
    try min_heap.insert(5);
    try min_heap.insert(4);
    try min_heap.insert(45);
    min_heap.printHeap();

    std.debug.print("Minimum element: {}\n", .{min_heap.getMin().?});
    std.debug.print("Extracted min: {}\n", .{min_heap.extractMin().?});
    min_heap.printHeap();
}
