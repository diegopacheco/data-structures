interface Bst {
    fun insert(data: Int)
    fun search(data: Int): Boolean
    fun remove(data: Int)
    fun inorderTraversal()
    fun preorderTraversal()
    fun postorderTraversal()
}