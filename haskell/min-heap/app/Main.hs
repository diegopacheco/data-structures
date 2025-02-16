module Main where
import Heap

main :: IO ()
main = do
  let heap1 = insert 3 Empty
  let heap2 = insert 2 heap1
  let heap3 = insert 15 heap2
  let heap4 = insert 5 heap3
  let heap5 = insert 4 heap4
  let heap6 = insert 45 heap5

  putStrLn (printHeap heap6)
  putStrLn ("Minimum element: " ++ show (getMin heap6))
  let (minVal, newHeap) = extractMin heap6
  putStrLn ("Extracted min: " ++ show minVal)
  putStrLn (printHeap newHeap)