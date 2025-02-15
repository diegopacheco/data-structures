export class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

export default class BST {
    constructor() {
        this.root = null;
    }

    insert(data) {
        this.root = this.insertNode(this.root, data);
    }

    insertNode(node, data) {
        if (node === null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = this.insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = this.insertNode(node.right, data);
        }

        return node;
    }

    search(data) {
        return this.searchNode(this.root, data);
    }

    searchNode(node, data) {
        if (node === null) {
            return false;
        }

        if (data === node.data) {
            return true;
        } else if (data < node.data) {
            return this.searchNode(node.left, data);
        } else {
            return this.searchNode(node.right, data);
        }
    }

    remove(data) {
        this.root = this.removeNode(this.root, data);
    }

    removeNode(node, data) {
        if (node === null) {
            return null;
        }

        if (data < node.data) {
            node.left = this.removeNode(node.left, data);
        } else if (data > node.data) {
            node.right = this.removeNode(node.right, data);
        } else {
            if (node.left === null && node.right === null) {
                return null;
            } else if (node.left === null) {
                return node.right;
            } else if (node.right === null) {
                return node.left;
            }

            const temp = this.findMinNode(node.right);
            node.data = temp.data;
            node.right = this.removeNode(node.right, temp.data);
        }
        return node;
    }

    findMinNode(node) {
        let current = node;
        while (current.left !== null) {
            current = current.left;
        }
        return current;
    }

    inorderTraversal(node = this.root) {
        if (node !== null) {
            this.inorderTraversal(node.left);
            process.stdout.write(node.data + " ");
            this.inorderTraversal(node.right);
        }
    }

    preorderTraversal(node = this.root) {
        if (node !== null) {
            process.stdout.write(node.data + " ");
            this.preorderTraversal(node.left);
            this.preorderTraversal(node.right);
        }
    }

    postorderTraversal(node = this.root) {
        if (node !== null) {
            this.postorderTraversal(node.left);
            this.postorderTraversal(node.right);
            process.stdout.write(node.data + " ");
        }
    }
}
