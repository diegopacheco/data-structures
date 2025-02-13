import java.util.LinkedList;

public class SimpleHashTable<K, V> implements HashTable<K, V> {
    
    // should be much bigger and prime
    // doing small for testing
    private static final int TABLE_SIZE = 10;

    private final LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public SimpleHashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return bucket.remove(entry);
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (!bucket.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TABLE_SIZE; i++) {
            sb.append(String.format("Bucket[%d]: ", i));
            for (Entry<K, V> entry : table[i]) {
                sb.append(String.format("(%s:%s) ", entry.key, entry.value));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}