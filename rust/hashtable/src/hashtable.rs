use std::collections::hash_map::DefaultHasher;
use std::hash::{Hash, Hasher};

// should be prime number
// should be mutch bigger but is this way for testing
const TABLE_SIZE: usize = 10;

#[derive(Debug)]
struct Entry<K, V> {
    key: K,
    value: V,
}

pub struct HashTable<K, V> {
    table: Vec<Vec<Entry<K, V>>>,
}

impl<K: Hash + Eq, V> HashTable<K, V> {
    pub fn new() -> Self {
        let mut table = Vec::with_capacity(TABLE_SIZE);
        for _ in 0..TABLE_SIZE {
            table.push(Vec::new());
        }
        HashTable { table }
    }

    fn hash(&self, key: &K) -> usize {
        let mut hasher = DefaultHasher::new();
        key.hash(&mut hasher);
        hasher.finish() as usize % TABLE_SIZE
    }

    pub fn put(&mut self, key: K, value: V) {
        let index = self.hash(&key);
        let bucket = &mut self.table[index];

        for entry in bucket.iter_mut() {
            if entry.key == key {
                entry.value = value;
                return;
            }
        }
        bucket.push(Entry { key, value });
    }

    pub fn get(&self, key: &K) -> Option<&V> {
        let index = self.hash(key);
        let bucket = &self.table[index];

        bucket
            .iter()
            .find(|entry| entry.key == *key)
            .map(|entry| &entry.value)
    }

    pub fn remove(&mut self, key: &K) -> bool {
        let index = self.hash(key);
        let bucket = &mut self.table[index];

        if let Some(pos) = bucket.iter().position(|entry| entry.key == *key) {
            bucket.remove(pos);
            return true;
        }
        false
    }
}

impl<K, V> std::fmt::Display for HashTable<K, V>
where
    K: std::fmt::Debug,
    V: std::fmt::Debug,
{
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        for (i, bucket) in self.table.iter().enumerate() {
            writeln!(f, "Bucket[{}]: {:?}", i, 
                bucket.iter().map(|entry| 
                    format!("({:?}:{:?})", entry.key, entry.value)
                ).collect::<Vec<_>>().join(" ")
            )?;
        }
        Ok(())
    }
}