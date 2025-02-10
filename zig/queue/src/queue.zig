const std = @import("std");

pub fn Queue(comptime T: type, comptime capacity: usize) type {
    return struct {
        items: [capacity]T,
        front: usize,
        rear: usize,
        size: usize,

        const Self = @This();

        pub fn init() Self {
            return Self{
                .items = undefined,
                .front = 0,
                .rear = 0,
                .size = 0,
            };
        }

        pub fn enqueue(self: *Self, item: T) !void {
            if (self.isFull()) {
                return error.QueueOverflow;
            }
            self.items[self.rear] = item;
            self.rear = (self.rear + 1) % capacity;
            self.size += 1;
        }

        pub fn dequeue(self: *Self) !T {
            if (self.isEmpty()) {
                return error.QueueUnderflow;
            }
            const item = self.items[self.front];
            self.front = (self.front + 1) % capacity;
            self.size -= 1;
            return item;
        }

        pub fn peek(self: *const Self) ?T {
            if (self.isEmpty()) {
                return null;
            }
            return self.items[self.front];
        }

        pub fn isEmpty(self: *const Self) bool {
            return self.size == 0;
        }

        pub fn isFull(self: *const Self) bool {
            return self.size == capacity;
        }

        pub fn printQueue(self: *const Self) void {
            std.debug.print("Queue: [", .{});
            var i: usize = 0;
            while (i < self.size) : (i += 1) {
                const index = (self.front + i) % capacity;
                std.debug.print("{}", .{self.items[index]});
                if (i < self.size - 1) {
                    std.debug.print(", ", .{});
                }
            }
            std.debug.print("]\n", .{});
        }

        pub fn deinit(self: *Self) void {
            self.front = 0;
            self.rear = 0;
            self.size = 0;
            for (self.items[0..capacity]) |*item| {
                item.* = undefined;
            }
        }
    };
}

pub const QueueError = error{
    QueueOverflow,
    QueueUnderflow,
};
