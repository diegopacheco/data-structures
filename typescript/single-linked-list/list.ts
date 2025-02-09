export interface LNode<T> {
    data: T;
    next: LNode<T> | null;
}

export interface LinkedList<T> {
    insertAtBegin(data: T): void;
    insertAtEnd(data: T): void;
    deleteNode(data: T): void;
    searchNode(data: T): boolean;
    printList(): void;
}

export class LNode<T> implements LNode<T> {
    data: T;
    next: LNode<T> | null;

    constructor(data: T) {
        this.data = data;
        this.next = null;
    }
}

export class LinkedList<T> implements LinkedList<T> {
    private head: LNode<T> | null;
    private size: number;

    constructor() {
        this.head = null;
        this.size = 0;
    }

    insertAtBegin(data: T): void {
        const newNode = new LNode(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    insertAtEnd(data: T): void {
        const newNode = new LNode(data);

        if (!this.head) {
            this.head = newNode;
        } else {
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    deleteNode(data: T): void {
        let current = this.head;
        let previous: LNode<T> | null = null;

        while (current !== null) {
            if (current.data === data) {
                if (previous === null) {
                    this.head = current.next;
                } else {
                    previous.next = current.next;
                }
                this.size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    searchNode(data: T): boolean {
        let current = this.head;
        while (current !== null) {
            if (current.data === data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    printList(): void {
        let current = this.head;
        let str = "";
        while (current) {
            str += current.data + " ";
            current = current.next;
        }
        console.log(str);
    }
}