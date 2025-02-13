
trait HashTable[K, V]:
  def put(key: K, value: V): Unit
  def get(key: K): Option[V]
  def remove(key: K): Boolean
  def isEmpty: Boolean

case class Entry[K, V](key: K, var value: V)

// size should be bigger and prime
// using small for testing
class HashTableImpl[K, V](size: Int = 10) extends HashTable[K, V]:
  private val table: Array[List[Entry[K, V]]] = Array.fill(size)(List.empty)

  // should be better hashing, good hashing has less collision
  private def hash(key: K): Int = 
    Math.abs(key.hashCode % size)

  override def put(key: K, value: V): Unit =
    val index = hash(key)
    val bucket = table(index)
    
    bucket.find(_.key == key) match
      case Some(entry) => entry.value = value
      case None => table(index) = Entry(key, value) :: bucket

  override def get(key: K): Option[V] =
    val bucket = table(hash(key))
    bucket.find(_.key == key).map(_.value)

  override def remove(key: K): Boolean =
    val index = hash(key)
    val bucket = table(index)
    
    bucket.find(_.key == key) match
      case Some(_) =>
        table(index) = bucket.filterNot(_.key == key)
        true
      case None => false

  override def isEmpty: Boolean =
    table.forall(_.isEmpty)

  override def toString: String =
    table.zipWithIndex.map { (bucket, i) =>
      val entries = bucket.map(e => s"(${e.key}:${e.value})").mkString(" ")
      s"Bucket[$i]: $entries"
    }.mkString("\n")