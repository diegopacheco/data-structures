public class Main {
  public static void main(String[] args) {
      Bst bst = new SimpleBst();

      bst.insert(50);
      bst.insert(30);
      bst.insert(20);
      bst.insert(40);
      bst.insert(70);
      bst.insert(60);
      bst.insert(80);

      System.out.print("Inorder traversal of the BST: ");
      bst.inorderTraversal();

      System.out.print("Preorder traversal of the BST: ");
      bst.preorderTraversal();

      System.out.print("Postorder traversal of the BST: ");
      bst.postorderTraversal();

      System.out.println(bst.search(40) ? "40 is found in the BST" : "40 is not found in the BST");
      bst.remove(30);
      System.out.print("Inorder traversal after deleting 30: ");
      bst.inorderTraversal();
  }
}