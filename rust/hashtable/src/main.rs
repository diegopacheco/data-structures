mod hashtable;
use hashtable::HashTable;

fn main() {
    let mut ht = HashTable::new();
    ht.put("one", 100);
    ht.put("two", 200);
    ht.put("three", 300);
    
    println!("Initial HashTable:");
    print!("{}", ht);
    if let Some(value) = ht.get(&"two") {
        println!("\nValue for key 'two': {}", value);
    }
    
    println!("\nRemoving key 'two'...");
    ht.remove(&"two");
    println!("\nHashTable after removal:");
    print!("{}", ht);
}