#include <stdio.h>
#include "hashtable.h"

int main() {
    HashTable ht;
    initHashTable(&ht);
    
    put(&ht, 1, 100);
    put(&ht, 2, 200);
    put(&ht, 3, 300);
    
    printf("Initial HashTable:\n");
    print_table(&ht);
    
    int value;
    if (get(&ht, 2, &value)) {
        printf("\nValue for key 2: %d\n", value);
    }
    
    printf("\nRemoving key 2...\n");
    remove_key(&ht, 2);
    
    printf("\nHashTable after removal:\n");
    print_table(&ht);
    
    cleanup(&ht);
    return 0;
}