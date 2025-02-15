import BST from "./bst.js";

const bst = new BST();

bst.insert(50);
bst.insert(30);
bst.insert(20);
bst.insert(40);
bst.insert(70);
bst.insert(60);
bst.insert(80);

process.stdout.write("Inorder traversal of the BST: ");
bst.inorderTraversal();
console.log();

process.stdout.write("Preorder traversal of the BST: ");
bst.preorderTraversal();
console.log();

process.stdout.write("Postorder traversal of the BST: ");
bst.postorderTraversal();
console.log();

if (bst.search(40)) {
    console.log("40 is found in the BST");
} else {
    console.log("40 is not found in the BST");
}

bst.remove(30);
process.stdout.write("Inorder traversal after deleting 30: ");
bst.inorderTraversal();
console.log();