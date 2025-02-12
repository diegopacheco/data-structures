#include <iostream>
#include "hashtable.cpp"

int main() {
    HashTable<int, int> ht;
    
    ht.put(1, 100);
    ht.put(2, 200);
    ht.put(3, 300);
    std::cout << "Initial HashTable:\n" << ht << std::endl;
    
    int value;
    if (ht.get(2, value)) {
        std::cout << "Value for key 2: " << value << std::endl;
    }
    
    std::cout << "\nRemoving key 2...\n" << std::endl;
    ht.remove(2);
    std::cout << "HashTable after removal:\n" << ht;
    
    return 0;
}