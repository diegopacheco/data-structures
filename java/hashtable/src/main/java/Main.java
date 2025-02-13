public class Main {
  public static void main(String[] args) {
      HashTable<String, Integer> ht = new SimpleHashTable<>();

      ht.put("one", 100);
      ht.put("two", 200);
      ht.put("three", 300);

      System.out.println("Initial HashTable:");
      System.out.println(ht);

      System.out.println("Value for key 'two': " + ht.get("two"));

      System.out.println("\nRemoving key 'two'...\n");
      ht.remove("two");

      System.out.println("HashTable after removal:");
      System.out.println(ht);
  }
}