interface HashTable<K, V> {
    put(key: K, value: V): void;
    get(key: K): V | undefined;
    remove(key: K): boolean;
    isEmpty(): boolean;
    toString(): string;
}

class SimpleHashTable<K, V> implements HashTable<K, V> {
    private readonly table: Array<Array<[K, V]>>;
    private readonly size: number;

    // size should be much bigger and prime
    // using small for testing
    constructor(size: number = 10) {
        this.size = size;
        this.table = Array(size).fill(null).map(() => []);
    }

    // should be much better hashing
    // good hashing gives good even distribution of keys 
    private hash(key: K): number {
        const hashCode = JSON.stringify(key)
            .split('')
            .reduce((acc, char) => acc + char.charCodeAt(0), 0);
        return Math.abs(hashCode) % this.size;
    }

    public put(key: K, value: V): void {
        const index = this.hash(key);
        const bucket = this.table[index];

        for (let i = 0; i < bucket.length; i++) {
            if (bucket[i][0] === key) {
                bucket[i][1] = value;
                return;
            }
        }
        bucket.push([key, value]);
    }

    public get(key: K): V | undefined {
        const index = this.hash(key);
        const bucket = this.table[index];

        for (const [k, v] of bucket) {
            if (k === key) {
                return v;
            }
        }
        return undefined;
    }

    public remove(key: K): boolean {
        const index = this.hash(key);
        const bucket = this.table[index];

        for (let i = 0; i < bucket.length; i++) {
            if (bucket[i][0] === key) {
                bucket.splice(i, 1);
                return true;
            }
        }
        return false;
    }

    public isEmpty(): boolean {
        return this.table.every(bucket => bucket.length === 0);
    }

    public toString(): string {
        return this.table
            .map((bucket, i) => {
                const pairs = bucket
                    .map(([k, v]) => `(${k}:${v})`)
                    .join(' ');
                return `Bucket[${i}]: ${pairs}`;
            })
            .join('\n');
    }
}

export { HashTable, SimpleHashTable };