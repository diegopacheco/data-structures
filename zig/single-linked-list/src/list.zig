const std = @import("std");

pub const Node = struct {
    data: i32,
    next: ?*Node,
};

pub fn insertAtBegin(head: ?*Node, data: i32, allocator: std.mem.Allocator) !?*Node {
    const newNode = try allocator.create(Node);
    newNode.data = data;
    newNode.next = head;
    return newNode;
}

pub fn insertAtEnd(head: ?*Node, data: i32, allocator: std.mem.Allocator) !void {
    const newNode = try allocator.create(Node);
    newNode.data = data;
    newNode.next = null;

    if (head == null) {
        @panic("Can't insert at end of null list");
    }

    var last: *Node = head.?;
    while (last.next != null) {
        last = last.next.?;
    }
    last.next = newNode;
}

pub fn deleteNode(head: ?*Node, data: i32, allocator: std.mem.Allocator) !?*Node {
    var current: ?*Node = head;
    var prev: ?*Node = null;

    if (current != null and current.?.data == data) {
        const new_head = current.?.next;
        allocator.destroy(current.?);
        return new_head;
    }

    while (current != null and current.?.data != data) {
        prev = current;
        current = current.?.next;
    }
    if (current == null) {
        return head;
    }

    if (prev != null) {
        prev.?.next = current.?.next;
        allocator.destroy(current.?);
    }

    return head;
}

pub fn searchNode(head: ?*Node, data: i32) ?*Node {
    var current: ?*Node = head;
    while (current != null) {
        if (current.?.data == data) {
            return current;
        }
        current = current.?.next;
    }
    return null;
}

pub fn printList(head: ?*Node) void {
    var current: ?*Node = head;
    while (current != null) {
        std.debug.print("{} ", .{current.?.data});
        current = current.?.next;
    }
    std.debug.print("null\n", .{});
}

pub fn dealocateList(head: ?*Node, allocator: std.mem.Allocator) void {
    var current: ?*Node = head;
    while (current != null) {
        const next = current.?.next;
        allocator.destroy(current.?);
        current = next;
    }
}
