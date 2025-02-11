#include <stdio.h>
#include <stdlib.h>
#include "hashtable.h"

int hash(int key) {
    return abs(key) % TABLE_SIZE;
}

void initHashTable(HashTable* ht) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        ht->table[i] = NULL;
    }
}

void put(HashTable* ht, int key, int value) {
    int index = hash(key);
    
    Node* current = ht->table[index];
    while (current != NULL) {
        if (current->key == key) {
            current->value = value;
            return;
        }
        current = current->next;
    }
    
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->key = key;
    newNode->value = value;
    newNode->next = ht->table[index];
    ht->table[index] = newNode;
}

bool get(HashTable* ht, int key, int* value) {
    int index = hash(key);
    
    Node* current = ht->table[index];
    while (current != NULL) {
        if (current->key == key) {
            *value = current->value;
            return true;
        }
        current = current->next;
    }
    return false;
}

bool remove_key(HashTable* ht, int key) {
    int index = hash(key);
    
    Node* current = ht->table[index];
    Node* prev = NULL;
    
    while (current != NULL) {
        if (current->key == key) {
            if (prev == NULL) {
                ht->table[index] = current->next;
            } else {
                prev->next = current->next;
            }
            free(current);
            return true;
        }
        prev = current;
        current = current->next;
    }
    return false;
}

void print_table(HashTable* ht) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        printf("Bucket[%d]: ", i);
        Node* current = ht->table[i];
        while (current != NULL) {
            printf("(%d:%d) ", current->key, current->value);
            current = current->next;
        }
        printf("\n");
    }
}

void cleanup(HashTable* ht) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Node* current = ht->table[i];
        while (current != NULL) {
            Node* next = current->next;
            free(current);
            current = next;
        }
        ht->table[i] = NULL;
    }
}