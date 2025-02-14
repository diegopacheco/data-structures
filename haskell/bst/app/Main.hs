module Main where

import Bst

main :: IO ()
main = do
  let root = empty
      root1 = insert 50 root
      root2 = insert 30 root1
      root3 = insert 20 root2
      root4 = insert 40 root3
      root5 = insert 70 root4
      root6 = insert 60 root5
      root7 = insert 80 root6

  putStr "Inorder traversal of the BST: "
  inorderTraversal root7
  putStrLn ""

  putStr "Preorder traversal of the BST: "
  preorderTraversal root7
  putStrLn ""

  putStr "Postorder traversal of the BST: "
  postorderTraversal root7
  putStrLn ""

  if search 40 root7
    then putStrLn "40 is found in the BST"
    else putStrLn "40 is not found in the BST"

  let root8 = delete 30 root7
  putStr "Inorder traversal after deleting 30: "
  inorderTraversal root8
  putStrLn ""