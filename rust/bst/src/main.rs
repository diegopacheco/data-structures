mod bst;

use bst::BST;

fn main() {
    let mut bst = BST::new();

    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);

    print!("Inorder traversal of the BST: ");
    bst.inorder_traversal();

    print!("Preorder traversal of the BST: ");
    bst.preorder_traversal();

    print!("Postorder traversal of the BST: ");
    bst.postorder_traversal();

    if bst.search(40) {
        println!("40 is found in the BST");
    } else {
        println!("40 is not found in the BST");
    }

    bst.remove(30);
    print!("Inorder traversal after deleting 30: ");
    bst.inorder_traversal();
}