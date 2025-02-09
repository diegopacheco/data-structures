const std = @import("std");

pub const Node = struct {
    data: i32,
    next: ?*Node,
};

pub fn insertAtBegin(head: ?*Node, data: i32, allocator: *std.mem.Allocator) !?*Node {
    const newNode = try allocator.create(Node);
    newNode.data = data;
    newNode.next = head;
    return newNode;
}

pub fn insertAtEnd(head: ?*Node, data: i32, allocator: *std.mem.Allocator) !void {
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

pub fn deleteNode(head: ?*Node, data: i32, allocator: *std.mem.Allocator) !?*Node {
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

pub fn dealocateList(head: ?*Node, allocator: *std.mem.Allocator) void {
    var current: ?*Node = head;
    while (current != null) {
        const next = current.?.next;
        allocator.destroy(current.?);
        current = next;
    }
}

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();

    var head: ?*Node = null;
    head = try insertAtBegin(head, 30, &allocator);
    head = try insertAtBegin(head, 20, &allocator);
    head = try insertAtBegin(head, 10, &allocator);

    try insertAtEnd(head, 40, &allocator);
    try insertAtEnd(head, 50, &allocator);

    std.debug.print("Linked list: ", .{});
    printList(head);

    head = try deleteNode(head, 40, &allocator);
    std.debug.print("Linked list: ", .{});
    printList(head);

    const searchResult = searchNode(head, 4);
    if (searchResult != null) {
        std.debug.print("Found {} in the list\n", .{searchResult.?.data});
    } else {
        std.debug.print("4 not found in the list\n", .{});
    }

    dealocateList(head, &allocator);
}
