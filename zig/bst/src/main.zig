const std = @import("std");
const BST = @import("bst.zig").BST;

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();

    var bst = BST(i32).init(allocator);
    defer bst.deinit();

    try bst.insert(50);
    try bst.insert(30);
    try bst.insert(20);
    try bst.insert(40);
    try bst.insert(70);
    try bst.insert(60);
    try bst.insert(80);

    bst.inorderTraversal();
    bst.preorderTraversal();
    bst.postorderTraversal();

    if (bst.search(40)) {
        std.debug.print("40 is found in the BST\n", .{});
    } else {
        std.debug.print("40 is not found in the BST\n", .{});
    }

    bst.remove(30);
    bst.inorderTraversalWithPrefix("Inorder traversal after deleting 30: ");
}
