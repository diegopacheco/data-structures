import { SimpleBst } from './bst';

const bst = new SimpleBst();

bst.insert(50);
bst.insert(30);
bst.insert(20);
bst.insert(40);
bst.insert(70);
bst.insert(60);
bst.insert(80);

bst.inorderTraversal();
bst.preorderTraversal();
bst.postorderTraversal();

if (bst.search(40)) {
    console.log("40 is found in the BST");
} else {
    console.log("40 is not found in the BST");
}

bst.remove(30);
bst.inorderTraversal("Inorder traversal after deleting 30: ");