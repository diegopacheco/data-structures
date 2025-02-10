const std = @import("std");
const Queue = @import("queue.zig").Queue;

pub fn main() !void {
    var queue = Queue(i32, 5).init();
    defer std.debug.print("Exiting program\n", .{});

    try queue.enqueue(100);
    try queue.enqueue(200);
    try queue.enqueue(300);

    std.debug.print("Queue: ", .{});
    queue.printQueue();

    const front = queue.peek() orelse 0;
    std.debug.print("Front: {?}\n", .{front});

    const item1 = try queue.dequeue();
    std.debug.print("Dequeued: {}\n", .{item1});

    const item2 = try queue.dequeue();
    std.debug.print("Dequeued: {}\n", .{item2});

    std.debug.print("Queue: ", .{});
    queue.printQueue();

    if (queue.isEmpty()) {
        std.debug.print("Queue is empty\n", .{});
    } else {
        std.debug.print("Queue is not empty\n", .{});
    }
    queue.deinit();
}
