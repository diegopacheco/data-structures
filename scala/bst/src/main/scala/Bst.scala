trait Bst {
  def insert(data: Int): Unit
  def search(data: Int): Boolean
  def remove(data: Int): Unit
  def inorderTraversal(): Unit
  def preorderTraversal(): Unit
  def postorderTraversal(): Unit
}

class SimpleBst extends Bst {
  private class Node(var data: Int) {
    var left: Node = null
    var right: Node = null
  }

  private var root: Node = null

  override def insert(data: Int): Unit = {
    root = insertRecursive(root, data)
  }

  private def insertRecursive(root: Node, data: Int): Node = {
    if (root == null) {
      return new Node(data)
    }

    if (data < root.data) {
      root.left = insertRecursive(root.left, data)
    } else if (data > root.data) {
      root.right = insertRecursive(root.right, data)
    }

    root
  }

  override def search(data: Int): Boolean = {
    searchRecursive(root, data)
  }

  private def searchRecursive(root: Node, data: Int): Boolean = {
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

  override def remove(data: Int): Unit = {
    root = deleteNode(root, data)
  }

  private def deleteNode(root: Node, data: Int): Node = {
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

      root.data = findMin(root.right).data
      root.right = deleteNode(root.right, root.data)
    }

    root
  }

  private def findMin(root: Node): Node = {
    var current = root
    while (current.left != null) {
      current = current.left
    }
    current
  }

  override def inorderTraversal(): Unit = {
    inorderTraversalRecursive(root)
    println()
  }

  private def inorderTraversalRecursive(root: Node): Unit = {
    if (root != null) {
      inorderTraversalRecursive(root.left)
      print(root.data + " ")
      inorderTraversalRecursive(root.right)
    }
  }

  override def preorderTraversal(): Unit = {
    preorderTraversalRecursive(root)
    println()
  }

  private def preorderTraversalRecursive(root: Node): Unit = {
    if (root != null) {
      print(root.data + " ")
      preorderTraversalRecursive(root.left)
      preorderTraversalRecursive(root.right)
    }
  }

  override def postorderTraversal(): Unit = {
    postorderTraversalRecursive(root)
    println()
  }

  private def postorderTraversalRecursive(root: Node): Unit = {
    if (root != null) {
      postorderTraversalRecursive(root.left)
      postorderTraversalRecursive(root.right)
      print(root.data + " ")
    }
  }
}