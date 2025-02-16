export interface Bst {
    insert(data: number): void;
    search(data: number): boolean;
    remove(data: number): void;
    inorderTraversal(prefix?: string): void;
    preorderTraversal(): void;
    postorderTraversal(): void;
}

class Node {
    data: number;
    left: Node | null;
    right: Node | null;

    constructor(data: number) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

export class SimpleBst implements Bst {
    private root: Node | null;

    constructor() {
        this.root = null;
    }

    insert(data: number): void {
        this.root = this.insertRecursive(this.root, data);
    }

    private insertRecursive(root: Node | null, data: number): Node | null {
        if (root === null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = this.insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = this.insertRecursive(root.right, data);
        }

        return root;
    }

    search(data: number): boolean {
        return this.searchRecursive(this.root, data);
    }

    private searchRecursive(root: Node | null, data: number): boolean {
        if (root === null) {
            return false;
        }

        if (data === root.data) {
            return true;
        } else if (data < root.data) {
            return this.searchRecursive(root.left, data);
        } else {
            return this.searchRecursive(root.right, data);
        }
    }

    remove(data: number): void {
        this.root = this.removeNode(this.root, data);
    }

    private removeNode(node: Node | null, data: number): Node | null {
        if (node === null) {
            return null;
        }

        if (data < node.data) {
            node.left = this.removeNode(node.left, data);
        } else if (data > node.data) {
            node.right = this.removeNode(node.right, data);
        } else {
            if (node.left === null) {
                return node.right;
            } else if (node.right === null) {
                return node.left;
            }

            const temp = this.findMin(node.right);
            node.data = temp.data;
            node.right = this.removeNode(node.right, temp.data);
        }
        return node;
    }

    private findMin(node: Node): Node {
        let current = node;
        while (current.left !== null) {
            current = current.left;
        }
        return current;
    }

    inorderTraversal(prefix: string = "Inorder traversal of the BST: "): void {
        process.stdout.write(prefix);
        this.inorderTraversalRecursive(this.root);
        console.log();
    }

    private inorderTraversalRecursive(node: Node | null): void {
        if (node !== null) {
            this.inorderTraversalRecursive(node.left);
            process.stdout.write(node.data + " ");
            this.inorderTraversalRecursive(node.right);
        }
    }

    preorderTraversal(): void {
        process.stdout.write("Preorder traversal of the BST: ");
        this.preorderTraversalRecursive(this.root);
        console.log();
    }

    private preorderTraversalRecursive(node: Node | null): void {
        if (node !== null) {
            process.stdout.write(node.data + " ");
            this.preorderTraversalRecursive(node.left);
            this.preorderTraversalRecursive(node.right);
        }
    }

    postorderTraversal(): void {
        process.stdout.write("Postorder traversal of the BST: ");
        this.postorderTraversalRecursive(this.root);
        console.log();
    }

    private postorderTraversalRecursive(node: Node | null): void {
        if (node !== null) {
            this.postorderTraversalRecursive(node.left);
            this.postorderTraversalRecursive(node.right);
            process.stdout.write(node.data + " ");
        }
    }
}