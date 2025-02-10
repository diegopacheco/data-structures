module Queue
    ( Queue(..)
    , empty
    , isEmpty
    , enqueue
    , dequeue
    , front
    ) where

data Queue a = Queue [a]
    deriving Eq

instance Show a => Show (Queue a) where
    show (Queue xs) = "Queue: " ++ show xs

empty :: Queue a
empty = Queue []

isEmpty :: Queue a -> Bool
isEmpty (Queue []) = True
isEmpty _         = False

enqueue :: a -> Queue a -> Queue a
enqueue x (Queue xs) = Queue (xs ++ [x])

dequeue :: Queue a -> Maybe (a, Queue a)
dequeue (Queue [])     = Nothing
dequeue (Queue (x:xs)) = Just (x, Queue xs)

front :: Queue a -> Maybe a
front (Queue [])    = Nothing
front (Queue (x:_)) = Just x