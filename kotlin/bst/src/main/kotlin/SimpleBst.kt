class SimpleBst : Bst {
    private class Node(var data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    private var root: Node? = null

    override fun insert(data: Int) {
        root = insertRecursive(root, data)
    }

    private fun insertRecursive(root: Node?, data: Int): Node? {
        if (root == null) {
            return Node(data)
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data)
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data)
        }

        return root
    }

    override fun search(data: Int): Boolean {
        return searchRecursive(root, data)
    }

    private fun searchRecursive(root: Node?, data: Int): Boolean {
        if (root == null) {
            return false
        }

        if (data == root.data) {
            return true
        } else if (data < root.data) {
            return searchRecursive(root.left, data)
        } else {
            return searchRecursive(root.right, data)
        }
    }

    override fun remove(data: Int) {
        root = deleteNode(root, data)
    }

    private fun deleteNode(root: Node?, data: Int): Node? {
        if (root == null) {
            return null
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data)
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data)
        } else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            root.data = findMin(root.right!!)
            root.right = deleteNode(root.right, root.data)
        }

        return root
    }

    private fun findMin(root: Node): Int {
        var current = root
        while (current.left != null) {
            current = current.left!!
        }
        return current.data
    }

    override fun inorderTraversal() {
        inorderTraversalRecursive(root)
        println()
    }

    private fun inorderTraversalRecursive(root: Node?) {
        if (root != null) {
            inorderTraversalRecursive(root.left)
            print("${root.data} ")
            inorderTraversalRecursive(root.right)
        }
    }

    override fun preorderTraversal() {
        preorderTraversalRecursive(root)
        println()
    }

    private fun preorderTraversalRecursive(root: Node?) {
        if (root != null) {
            print("${root.data} ")
            preorderTraversalRecursive(root.left)
            preorderTraversalRecursive(root.right)
        }
    }

    override fun postorderTraversal() {
        postorderTraversalRecursive(root)
        println()
    }

    private fun postorderTraversalRecursive(root: Node?) {
        if (root != null) {
            postorderTraversalRecursive(root.left)
            postorderTraversalRecursive(root.right)
            print("${root.data} ")
        }
    }
}