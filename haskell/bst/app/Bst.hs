module Bst (
  BST,
  empty,
  insert,
  search,
  delete,
  inorderTraversal,
  preorderTraversal,
  postorderTraversal
) where

data BST a = Empty | Node a (BST a) (BST a) deriving (Show)

empty :: BST a
empty = Empty

insert :: (Ord a) => a -> BST a -> BST a
insert x Empty = Node x Empty Empty
insert x (Node a left right)
  | x == a    = Node a left right
  | x < a     = Node a (insert x left) right
  | otherwise = Node a left (insert x right)

search :: (Ord a) => a -> BST a -> Bool
search x Empty = False
search x (Node a left right)
  | x == a    = True
  | x < a     = search x left
  | otherwise = search x right

findMin :: BST a -> Maybe a
findMin Empty = Nothing
findMin (Node a Empty _) = Just a
findMin (Node _ left _) = findMin left

delete :: (Ord a) => a -> BST a -> BST a
delete x Empty = Empty
delete x (Node a left right)
  | x < a     = Node a (delete x left) right
  | x > a     = Node a left (delete x right)
  | otherwise = case (left, right) of
                  (Empty, _) -> right
                  (_, Empty) -> left
                  (_, _) -> case findMin right of
                              Just minVal -> Node minVal left (delete minVal right)
                              Nothing -> Empty

inorderTraversal :: (Show a) => BST a -> IO ()
inorderTraversal Empty = return ()
inorderTraversal (Node a left right) = do
  inorderTraversal left
  putStr $ show a ++ " "
  inorderTraversal right

preorderTraversal :: (Show a) => BST a -> IO ()
preorderTraversal Empty = return ()
preorderTraversal (Node a left right) = do
  putStr $ show a ++ " "
  preorderTraversal left
  preorderTraversal right

postorderTraversal :: (Show a) => BST a -> IO ()
postorderTraversal Empty = return ()
postorderTraversal (Node a left right) = do
  postorderTraversal left
  postorderTraversal right
  putStr $ show a ++ " "