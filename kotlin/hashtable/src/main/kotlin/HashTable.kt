interface HashTable<K, V> {
    fun put(key: K, value: V)
    fun get(key: K): V?
    fun remove(key: K): Boolean
    fun isEmpty(): Boolean
}

data class Entry<K, V>(
    val key: K,
    var value: V
)