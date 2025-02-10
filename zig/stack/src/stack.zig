const std = @import("std");

pub fn Stack(comptime T: type, comptime capacity: usize) type {
    return struct {
        items: [capacity]T,
        top: usize,

        const Self = @This();

        pub fn init() Self {
            return Self{
                .items = undefined,
                .top = 0,
            };
        }

        pub fn push(self: *Self, value: T) !void {
            if (self.top == capacity) {
                return error.StackOverflow;
            }
            self.items[self.top] = value;
            self.top += 1;
        }

        pub fn pop(self: *Self) !T {
            if (self.top == 0) {
                return error.StackUnderflow;
            }
            self.top -= 1;
            return self.items[self.top];
        }

        pub fn peek(self: *const Self) ?T {
            if (self.top == 0) {
                return null;
            }
            return self.items[self.top - 1];
        }

        pub fn isEmpty(self: *const Self) bool {
            return self.top == 0;
        }

        pub fn isFull(self: *const Self) bool {
            return self.top == capacity;
        }

        pub fn printStack(self: *const Self) void {
            std.debug.print("Stack: [", .{});
            var i: usize = 0;
            while (i < self.top) : (i += 1) {
                std.debug.print("{}, ", .{self.items[i]});
            }
            std.debug.print("]\n", .{});
        }

        pub fn deinit(self: *Self) void {
            self.top = 0;
            for (self.items[0..capacity]) |*item| {
                item.* = undefined;
            }
        }
    };
}

pub const StackError = error{
    StackOverflow,
    StackUnderflow,
};
