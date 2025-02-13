public interface HashTable<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean remove(K key);
    boolean isEmpty();
    String toString();
}