public interface Bst {
    void insert(int data);
    boolean search(int data);
    void remove(int data);
    void inorderTraversal();
    void preorderTraversal();
    void postorderTraversal();
}