from hashtable import HashTable

def main():
    ht = HashTable()
    
    ht.put("one", 100)
    ht.put("two", 200)
    ht.put("three", 300)
    
    print("Initial HashTable:")
    print(ht)
    print(f"\nValue for key 'two': {ht.get('two')}")
    
    print("\nRemoving key 'two'...")
    ht.remove("two")
    print("\nHashTable after removal:")
    print(ht)

if __name__ == "__main__":
    main()