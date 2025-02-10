const std = @import("std");
const Stack = @import("stack.zig");

pub fn main() !void {
    var stack = Stack.init(i32, 5);

    try stack.push(100);
    try stack.push(200);
    try stack.push(300);
    stack.print_stack();

    std.debug.print("Top element: {?}\n", .{stack.peek()});

    const popped1 = try stack.pop();
    std.debug.print("Popped: {?}\n", .{popped1});

    const popped2 = try stack.pop();
    std.debug.print("Popped: {?}\n", .{popped2});

    if (stack.isEmpty()) {
        std.debug.print("Stack is empty.\n", .{});
    } else {
        std.debug.print("Stack is not empty.\n", .{});
    }
    stack.print_stack();
}
