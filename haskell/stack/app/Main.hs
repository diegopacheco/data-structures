module Main where

import Stack

main :: IO ()
main = do
    let stack = push 30 $ push 20 $ push 10 empty :: Stack Int
    putStrLn $ show stack
    
    case peek stack of
        Nothing -> putStrLn "Stack is empty"
        Just x -> putStrLn $ "Top element: " ++ show x
    
    case pop stack of
        Nothing -> putStrLn "Stack is empty"
        Just (x, s1) -> do
            putStrLn $ "Pop: " ++ show x
            case pop s1 of
                Nothing -> putStrLn "Stack is empty"
                Just (y, s2) -> do
                    putStrLn $ "Pop: " ++ show y
                    putStrLn $ show s2