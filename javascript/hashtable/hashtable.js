export default class HashTable {
    constructor(size = 10) {
        this.table = new Array(size).fill(null).map(() => []);
    }

    hash(key) {
        let total = 0;
        for(let i = 0; i < key.length; i++) {
            total += key.charCodeAt(i);
        }
        return total % this.table.length;
    }

    put(key, value) {
        const index = this.hash(key);
        const bucket = this.table[index];
        
        for(let i = 0; i < bucket.length; i++) {
            if(bucket[i][0] === key) {
                bucket[i][1] = value;
                return;
            }
        }
        bucket.push([key, value]);
    }

    get(key) {
        const index = this.hash(key);
        const bucket = this.table[index];
        
        for(const [k, v] of bucket) {
            if(k === key) {
                return v;
            }
        }
        return undefined;
    }

    remove(key) {
        const index = this.hash(key);
        const bucket = this.table[index];
        
        for(let i = 0; i < bucket.length; i++) {
            if(bucket[i][0] === key) {
                bucket.splice(i, 1);
                return true;
            }
        }
        return false;
    }

    toString() {
        return this.table.map((bucket, i) => {
            const pairs = bucket.map(([k, v]) => `(${k}:${v})`).join(' ');
            return `Bucket[${i}]: ${pairs}`;
        }).join('\n');
    }
}