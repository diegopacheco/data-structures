class HashTable:
    # size should be prime and much bigger
    def __init__(self, size=10):
        self.size = size
        self.table = [[] for _ in range(size)]
    
    def _hash(self, key):
        """Simple hash function using built-in hash"""
        # bad but testing is ok
        # good hash func should distribute keys evenly
        return abs(hash(key)) % self.size
    
    def put(self, key, value):
        """Add or update a key-value pair in the hash table"""
        index = self._hash(key)
        bucket = self.table[index]
        
        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket[i] = (key, value)
                return
        bucket.append((key, value))
    
    def get(self, key):
        """Get value for a given key, return None if not found"""
        index = self._hash(key)
        bucket = self.table[index]
        
        for k, v in bucket:
            if k == key:
                return v
        return None
    
    def remove(self, key):
        """Remove a key-value pair, return True if removed, False if not found"""
        index = self._hash(key)
        bucket = self.table[index]
        
        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket.pop(i)
                return True
        return False
    
    def __str__(self):
        """String representation of the hash table"""
        result = []
        for i, bucket in enumerate(self.table):
            entries = " ".join(f"({k}:{v})" for k, v in bucket)
            result.append(f"Bucket[{i}]: {entries}")
        return "\n".join(result)