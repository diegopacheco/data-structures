import HashTable from "./hashtable.js";

const ht = new HashTable();
ht.put("one", 100);
ht.put("two", 200);
ht.put("three", 300);

console.log("Initial HashTable:");
console.log(ht.toString());
console.log("\nValue for key 'two':", ht.get("two"));

console.log("\nRemoving key 'two'...");
ht.remove("two");

console.log("\nHashTable after removal:");
console.log(ht.toString());