module Main where

import Hashtable
import Prelude hiding (lookup)

main :: IO ()
main = do
    let ht = empty
        ht1 = insert "one" 100 ht
        ht2 = insert "two" 200 ht1
        ht3 = insert "three" 300 ht2
    
    putStrLn "Initial HashTable:"
    putStr $ toString ht3
    
    case lookup "two" ht3 of
        Just value -> putStrLn $ "\nValue for key 'two': " ++ show value
        Nothing -> putStrLn "\nKey 'two' not found"
    
    putStrLn "\nRemoving key 'two'..."
    let ht4 = delete "two" ht3
    
    putStrLn "\nHashTable after removal:"
    putStr $ toString ht4