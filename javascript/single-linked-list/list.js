class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    insertAtBegin(data) {
        let newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    insertAtEnd(data) {
        let newNode = new Node(data);

        if (!this.head) {
            this.head = newNode;
        } else {
            let cur = this.head;
            while (cur.next) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        this.size++;
    }

    deleteNode(data) {
        let cur = this.head;
        let previous = null;
        if (cur != null && cur.data === data) {
            this.head = cur.next;
            this.size--;
            return;
        }

        while (cur != null && cur.data !== data) {
            previous = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        previous.next = cur.next;
        this.size--;
    }

    searchNode(data) {
        let cur = this.head;
        while (cur != null) {
            if (cur.data === data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    printList() {
        let cur = this.head;
        let str = "";
        while (cur) {
            str += cur.data + " ";
            cur = cur.next;
        }
        console.log(str);
    }
}

export default LinkedList;