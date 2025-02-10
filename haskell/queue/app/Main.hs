module Main where

import Queue

main :: IO ()
main = do
    let queue = foldr enqueue empty [300, 200, 100]
    putStrLn $ show queue

    case front queue of
        Nothing -> putStrLn "Queue is empty"
        Just x  -> putStrLn $ "Front element: " ++ show x

    case dequeue queue of
        Nothing -> putStrLn "Queue is empty"
        Just (x, q1) -> do
            putStrLn $ "Dequeued: " ++ show x
            case dequeue q1 of 
                Nothing -> putStrLn "Queue is empty"
                Just (y, q2) -> do
                    putStrLn $ "Dequeued: " ++ show y
                    putStrLn $ if isEmpty q2 
                              then "Queue is empty" 
                              else "Queue is not empty"
                    putStrLn $ show q2