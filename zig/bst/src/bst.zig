const std = @import("std");
const Allocator = std.mem.Allocator;

pub fn BST(comptime T: type) type {
    return struct {
        const Self = @This();
        const Node = struct {
            data: T,
            left: ?*Node,
            right: ?*Node,
        };

        root: ?*Node,
        allocator: Allocator,

        pub fn init(allocator: Allocator) Self {
            return .{
                .root = null,
                .allocator = allocator,
            };
        }

        pub fn deinit(self: *Self) void {
            if (self.root) |root| {
                self.freeNode(root);
            }
        }

        fn freeNode(self: *Self, node: *Node) void {
            if (node.left) |left| {
                self.freeNode(left);
            }
            if (node.right) |right| {
                self.freeNode(right);
            }
            self.allocator.destroy(node);
        }

        pub fn insert(self: *Self, value: T) !void {
            if (self.root) |root| {
                try self.insertRec(root, value);
            } else {
                const node = try self.allocator.create(Node);
                node.* = .{ .data = value, .left = null, .right = null };
                self.root = node;
            }
        }

        fn insertRec(self: *Self, node: *Node, value: T) !void {
            if (value < node.data) {
                if (node.left) |left| {
                    try self.insertRec(left, value);
                } else {
                    const new_node = try self.allocator.create(Node);
                    new_node.* = .{ .data = value, .left = null, .right = null };
                    node.left = new_node;
                }
            } else if (value > node.data) {
                if (node.right) |right| {
                    try self.insertRec(right, value);
                } else {
                    const new_node = try self.allocator.create(Node);
                    new_node.* = .{ .data = value, .left = null, .right = null };
                    node.right = new_node;
                }
            }
        }

        pub fn search(self: *const Self, value: T) bool {
            return if (self.root) |root| self.searchRec(root, value) else false;
        }

        fn searchRec(self: *const Self, node: *const Node, value: T) bool {
            if (value == node.data) return true;
            if (value < node.data) {
                return if (node.left) |left| self.searchRec(left, value) else false;
            } else {
                return if (node.right) |right| self.searchRec(right, value) else false;
            }
        }

        pub fn remove(self: *Self, value: T) void {
            self.root = self.removeRec(self.root, value);
        }

        fn removeRec(self: *Self, node: ?*Node, value: T) ?*Node {
            if (node) |n| {
                if (value < n.data) {
                    n.left = self.removeRec(n.left, value);
                } else if (value > n.data) {
                    n.right = self.removeRec(n.right, value);
                } else {
                    if (n.left == null) {
                        const temp = n.right;
                        self.allocator.destroy(n);
                        return temp;
                    } else if (n.right == null) {
                        const temp = n.left;
                        self.allocator.destroy(n);
                        return temp;
                    }
                    const min_node = findMinNode(n.right.?);
                    n.data = min_node.data;
                    n.right = self.removeRec(n.right, min_node.data);
                }
                return n;
            }
            return null;
        }

        fn findMinNode(node: *Node) *Node {
            var current = node;
            while (current.left) |left| {
                current = left;
            }
            return current;
        }

        pub fn inorderTraversalWithPrefix(self: *const Self, prefix: []const u8) void {
            std.debug.print("{s}", .{prefix});
            if (self.root) |root| {
                self.inorderTraversalRec(root);
            }
            std.debug.print("\n", .{});
        }

        pub fn inorderTraversal(self: *const Self) void {
            self.inorderTraversalWithPrefix("Inorder traversal of the BST: ");
        }

        fn inorderTraversalRec(self: *const Self, node: *const Node) void {
            if (node.left) |left| {
                self.inorderTraversalRec(left);
            }
            std.debug.print("{} ", .{node.data});
            if (node.right) |right| {
                self.inorderTraversalRec(right);
            }
        }

        pub fn preorderTraversal(self: *const Self) void {
            std.debug.print("Preorder traversal of the BST: ", .{});
            if (self.root) |root| {
                self.preorderTraversalRec(root);
            }
            std.debug.print("\n", .{});
        }

        fn preorderTraversalRec(self: *const Self, node: *const Node) void {
            std.debug.print("{} ", .{node.data});
            if (node.left) |left| {
                self.preorderTraversalRec(left);
            }
            if (node.right) |right| {
                self.preorderTraversalRec(right);
            }
        }

        pub fn postorderTraversal(self: *const Self) void {
            std.debug.print("Postorder traversal of the BST: ", .{});
            if (self.root) |root| {
                self.postorderTraversalRec(root);
            }
            std.debug.print("\n", .{});
        }

        fn postorderTraversalRec(self: *const Self, node: *const Node) void {
            if (node.left) |left| {
                self.postorderTraversalRec(left);
            }
            if (node.right) |right| {
                self.postorderTraversalRec(right);
            }
            std.debug.print("{} ", .{node.data});
        }
    };
}
