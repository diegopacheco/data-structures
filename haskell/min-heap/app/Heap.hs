module Heap where

data MinHeap = Empty | Node Int MinHeap MinHeap deriving (Show)

insert :: Int -> MinHeap -> MinHeap
insert x Empty = Node x Empty Empty
insert x h@(Node val left right)
  | x <= val  = Node x (insert val left) right
  | otherwise = Node val (insert x left) right

extractMin :: MinHeap -> (Maybe Int, MinHeap)
extractMin Empty = (Nothing, Empty)
extractMin (Node val Empty Empty) = (Just val, Empty)
extractMin (Node val left right) = (Just val, merge left right)

getMin :: MinHeap -> Maybe Int
getMin Empty = Nothing
getMin (Node val _ _) = Just val

merge :: MinHeap -> MinHeap -> MinHeap
merge h1 Empty = h1
merge Empty h2 = h2
merge h1@(Node v1 l1 r1) h2@(Node v2 l2 r2)
  | v1 <= v2  = Node v1 l1 (merge r1 h2)
  | otherwise = Node v2 l2 (merge h1 r2)

printHeap :: MinHeap -> String
printHeap Empty = "Min Heap: "
printHeap h = "Min Heap: " ++ showHeap h

showHeap :: MinHeap -> String
showHeap Empty = ""
showHeap (Node val left right) = show val ++ " " ++ showHeap left ++ showHeap right