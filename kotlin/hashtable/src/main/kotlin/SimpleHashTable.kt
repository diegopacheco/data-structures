// size should prime and bigger
// using smaller for testing
class SimpleHashTable<K, V>(private val size: Int = 10) : HashTable<K, V> {
    
    private val table: Array<MutableList<Entry<K, V>>> = Array(size) { mutableListOf() }

    // very bad hashing but for testing is fine.
    // should use better hashing algorithm
    // good hashing algorithm should distribute keys uniformly
    private fun hash(key: K): Int = 
        Math.abs(key.hashCode() % size)

    override fun put(key: K, value: V) {
        val index = hash(key)
        val bucket = table[index]
        
        val existingEntry = bucket.find { it.key == key }
        if (existingEntry != null) {
            existingEntry.value = value
        } else {
            bucket.add(Entry(key, value))
        }
    }

    override fun get(key: K): V? {
        val index = hash(key)
        return table[index]
            .find { it.key == key }
            ?.value
    }

    override fun remove(key: K): Boolean {
        val index = hash(key)
        val bucket = table[index]
        return bucket.removeIf { it.key == key }
    }

    override fun isEmpty(): Boolean =
        table.all { it.isEmpty() }

    override fun toString(): String =
        table.mapIndexed { index, bucket ->
            val entries = bucket.joinToString(" ") { 
                "(${it.key}:${it.value})" 
            }
            "Bucket[$index]: $entries"
        }.joinToString("\n")
}