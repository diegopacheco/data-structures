const std = @import("std");
const Stack = @import("stack.zig").Stack;

pub fn main() !void {
    var stack = Stack(i32, 5).init();
    try stack.push(100);
    try stack.push(200);
    try stack.push(300);
    stack.printStack();

    std.debug.print("Top element: {?}\n", .{stack.peek()});
    const popped1 = try stack.pop();
    std.debug.print("Pop: {}\n", .{popped1});

    const popped2 = try stack.pop();
    std.debug.print("Pop: {}\n", .{popped2});

    if (stack.isEmpty()) {
        std.debug.print("Stack is empty.\n", .{});
    } else {
        std.debug.print("Stack is not empty.\n", .{});
    }
    stack.printStack();
    stack.deinit();
}
