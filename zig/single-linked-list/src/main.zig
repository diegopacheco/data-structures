const std = @import("std");
const list = @import("list.zig");

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();

    var head: ?*list.Node = null;
    head = try list.insertAtBegin(head, 30, allocator);
    head = try list.insertAtBegin(head, 20, allocator);
    head = try list.insertAtBegin(head, 10, allocator);

    try list.insertAtEnd(head, 40, allocator);
    try list.insertAtEnd(head, 50, allocator);

    std.debug.print("Linked list: ", .{});
    list.printList(head);

    head = try list.deleteNode(head, 40, allocator);
    std.debug.print("Linked list: ", .{});
    list.printList(head);

    const searchResult = list.searchNode(head, 4);
    if (searchResult != null) {
        std.debug.print("Found {} in the list\n", .{searchResult.?.data});
    } else {
        std.debug.print("4 not found in the list\n", .{});
    }

    list.dealocateList(head, allocator);
}
