module List
    ( List(..)
    , empty
    , isEmpty
    , cons
    , head
    , tail
    , length
    , toList
    , fromList
    , contains
    , printList
    ) where

import Prelude hiding (head, tail, length)

data List a = Empty | Cons a (List a)

instance Show a => Show (List a) where
    show lst = unwords $ map show (toList lst)

empty :: List a
empty = Empty

isEmpty :: List a -> Bool
isEmpty Empty = True
isEmpty _     = False

cons :: a -> List a -> List a
cons x xs = Cons x xs

head :: List a -> Maybe a
head Empty      = Nothing
head (Cons x _) = Just x

tail :: List a -> Maybe (List a)
tail Empty        = Nothing
tail (Cons _ xs)  = Just xs

length :: List a -> Int
length Empty        = 0
length (Cons _ xs)  = 1 + length xs

toList :: List a -> [a]
toList Empty        = []
toList (Cons x xs)  = x : toList xs

fromList :: [a] -> List a
fromList = foldr cons empty

contains :: Eq a => List a -> a -> Bool
contains Empty _ = False
contains (Cons x xs) y = x == y || contains xs y

printList :: Show a => List a -> IO ()
printList lst = putStrLn $ "List Elements: " ++ show (toList lst)