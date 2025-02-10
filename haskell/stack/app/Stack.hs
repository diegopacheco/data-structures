module Stack
    ( Stack(..)
    , empty
    , isEmpty
    , push
    , pop
    , peek
    , size
    , printStack
    ) where

data Stack a = Empty | Node a (Stack a)

instance Show a => Show (Stack a) where
    show s = "Stack: " ++ unwords (map show (toList s))
        where
            toList Empty = []
            toList (Node x rest) = toList rest ++ [x]

empty :: Stack a
empty = Empty

isEmpty :: Stack a -> Bool
isEmpty Empty = True
isEmpty _     = False

push :: a -> Stack a -> Stack a
push x s = Node x s

pop :: Stack a -> Maybe (a, Stack a)
pop Empty        = Nothing
pop (Node x xs)  = Just (x, xs)

peek :: Stack a -> Maybe a
peek Empty       = Nothing
peek (Node x _)  = Just x

size :: Stack a -> Int
size Empty       = 0
size (Node _ xs) = 1 + size xs

printStack :: Show a => Stack a -> IO ()
printStack Empty = putStrLn "Empty"
printStack (Node x xs) = do
    putStrLn $ show x
    printStack xs
   

