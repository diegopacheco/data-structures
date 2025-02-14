const std = @import("std");
const HashTable = @import("hashtable.zig").HashTable;

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();

    var ht = HashTable.init(allocator);
    defer ht.deinit();

    try ht.put("one", 100);
    try ht.put("two", 200);
    try ht.put("three", 300);
    std.debug.print("Initial HashTable:\n{}", .{ht});

    if (ht.get("two")) |value| {
        std.debug.print("\nValue for key 'two': {}\n", .{value});
    }

    std.debug.print("\nRemoving key 'two'...\n", .{});
    _ = ht.remove("two");

    std.debug.print("\nHashTable after removal:\n{}", .{ht});
}
