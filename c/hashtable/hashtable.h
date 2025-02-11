#ifndef HASHTABLE_H
#define HASHTABLE_H

#include <stdbool.h>

// should be more, ideally prime but for easy print keep it low.
#define TABLE_SIZE 10

typedef struct Node {
    int key;
    int value;
    struct Node* next;
} Node;

typedef struct {
    Node* table[TABLE_SIZE];
} HashTable;

void initHashTable(HashTable* ht);
void put(HashTable* ht, int key, int value);
bool get(HashTable* ht, int key, int* value);
bool remove_key(HashTable* ht, int key);
void print_table(HashTable* ht);
void cleanup(HashTable* ht);

#endif