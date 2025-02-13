@main 
def run(): Unit =
  val ht: HashTable[String, Int] = HashTableImpl[String, Int]()
  
  ht.put("one", 100)
  ht.put("two", 200)
  ht.put("three", 300)
  println("Initial HashTable:")
  println(ht)
  
  println(s"\nValue for key 'two': ${ht.get("two").getOrElse("not found")}")
  println("\nRemoving key 'two'...")
  ht.remove("two")
  
  println("\nHashTable after removal:")
  println(ht)