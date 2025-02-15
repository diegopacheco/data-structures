class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class SimpleBst implements Bst {
    private Node root;

    public SimpleBst() {
        this.root = null;
    }

    @Override
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    @Override
    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return searchRecursive(root.left, data);
        } else {
            return searchRecursive(root.right, data);
        }
    }

    @Override
    public void remove(int data) {
        root = deleteNode(root, data);
    }

    private Node deleteNode(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMin(root.right);
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    private int findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    @Override
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
        System.out.println();
    }

    private void inorderTraversalRecursive(Node root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.data + " ");
            inorderTraversalRecursive(root.right);
        }
    }

    @Override
    public void preorderTraversal() {
        preorderTraversalRecursive(root);
        System.out.println();
    }

    private void preorderTraversalRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        }
    }

    @Override
    public void postorderTraversal() {
        postorderTraversalRecursive(root);
        System.out.println();
    }

    private void postorderTraversalRecursive(Node root) {
        if (root != null) {
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }
}