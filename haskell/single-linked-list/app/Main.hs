module Main where

import List
import Prelude hiding (head, tail, length)

main :: IO ()
main = do
    let list = fromList [10,20,30,40,50] :: List Int
    putStrLn $ "List: " ++ show list
    putStrLn $ "List: " ++ show list
    let searchValue = 4
    putStrLn $ if contains list searchValue
               then show searchValue ++ " is in the list"
               else show searchValue ++ " is not in the list"