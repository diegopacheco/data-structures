#ifndef HASHTABLE_H
#define HASHTABLE_H

#include <iostream>
#include <list>
#include <vector>

template<typename K, typename V>
class HashTable {
private:
    //
    // should be prime and bigger
    // this is low just for testing
    //
    static const int TABLE_SIZE = 10;
    std::vector<std::list<std::pair<K, V>>> table;

    int hash(const K& key) const {
        return std::hash<K>{}(key) % TABLE_SIZE;
    }

public:
    HashTable() : table(TABLE_SIZE) {}

    void put(const K& key, const V& value) {
        int index = hash(key);
        auto& list = table[index];
        
        for (auto& pair : list) {
            if (pair.first == key) {
                pair.second = value;
                return;
            }
        }
        list.emplace_back(key, value);
    }

    bool get(const K& key, V& value) const {
        int index = hash(key);
        const auto& list = table[index];
        
        for (const auto& pair : list) {
            if (pair.first == key) {
                value = pair.second;
                return true;
            }
        }
        return false;
    }

    bool remove(const K& key) {
        int index = hash(key);
        auto& list = table[index];
        
        for (auto it = list.begin(); it != list.end(); ++it) {
            if (it->first == key) {
                list.erase(it);
                return true;
            }
        }
        return false;
    }

    friend std::ostream& operator<<(std::ostream& os, const HashTable& ht) {
        for (int i = 0; i < TABLE_SIZE; i++) {
            os << "Bucket[" << i << "]: ";
            for (const auto& pair : ht.table[i]) {
                os << "(" << pair.first << ":" << pair.second << ") ";
            }
            os << "\n";
        }
        return os;
    }
};

#endif