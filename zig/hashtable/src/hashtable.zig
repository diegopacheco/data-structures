const std = @import("std");
const Allocator = std.mem.Allocator;

// should be prime and bigger
// smaller for testing
pub const TABLE_SIZE: usize = 10;

pub const Entry = struct {
    key: []const u8,
    value: i32,
};

pub const HashTable = struct {
    table: [TABLE_SIZE]std.ArrayList(Entry),
    allocator: Allocator,

    pub fn init(allocator: Allocator) HashTable {
        var table: [TABLE_SIZE]std.ArrayList(Entry) = undefined;
        for (0..TABLE_SIZE) |i| {
            table[i] = std.ArrayList(Entry).init(allocator);
        }
        return .{
            .table = table,
            .allocator = allocator,
        };
    }

    pub fn deinit(self: *HashTable) void {
        for (0..TABLE_SIZE) |i| {
            for (self.table[i].items) |entry| {
                self.allocator.free(entry.key);
            }
            self.table[i].deinit();
        }
    }

    // should be better hash, good hash gives good even distribution
    fn hash(key: []const u8) usize {
        var result: usize = 0;
        for (key) |char| {
            result +%= @as(usize, char);
        }
        return result % TABLE_SIZE;
    }

    pub fn put(self: *HashTable, key: []const u8, value: i32) !void {
        const index = hash(key);
        const bucket = &self.table[index];

        for (bucket.items) |*entry| {
            if (std.mem.eql(u8, entry.key, key)) {
                entry.value = value;
                return;
            }
        }

        const key_copy = try self.allocator.dupe(u8, key);
        try bucket.append(.{ .key = key_copy, .value = value });
    }

    pub fn get(self: *const HashTable, key: []const u8) ?i32 {
        const index = hash(key);
        const bucket = &self.table[index];

        for (bucket.items) |entry| {
            if (std.mem.eql(u8, entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    pub fn remove(self: *HashTable, key: []const u8) bool {
        const index = hash(key);
        const bucket = &self.table[index];

        for (bucket.items, 0..) |entry, i| {
            if (std.mem.eql(u8, entry.key, key)) {
                self.allocator.free(entry.key);
                _ = bucket.orderedRemove(i);
                return true;
            }
        }
        return false;
    }

    pub fn format(
        self: HashTable,
        comptime fmt: []const u8,
        options: std.fmt.FormatOptions,
        writer: anytype,
    ) !void {
        _ = fmt;
        _ = options;

        for (self.table, 0..) |bucket, i| {
            try writer.print("Bucket[{}]: ", .{i});
            for (bucket.items) |entry| {
                try writer.print("({s}:{}) ", .{ entry.key, entry.value });
            }
            try writer.writeByte('\n');
        }
    }
};
