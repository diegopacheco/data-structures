fun main() {
  val ht: HashTable<String, Int> = SimpleHashTable()

  ht.put("one", 100)
  ht.put("two", 200)
  ht.put("three", 300)

  println("Initial HashTable:")
  println(ht)
  println("\nValue for key 'two': ${ht.get("two")}")

  println("\nRemoving key 'two'...")
  ht.remove("two")

  println("\nHashTable after removal:")
  println(ht)
}