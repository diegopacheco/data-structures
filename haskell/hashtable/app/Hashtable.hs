module Hashtable
    ( HashTable
    , empty
    , insert
    , lookup
    , delete
    , toString
    ) where

import qualified Data.Vector as V
import Data.Vector (Vector)
import qualified Data.List as L
import Data.Hashable (Hashable, hashWithSalt)
import Prelude hiding (lookup)

type Bucket k v = [(k, v)]
newtype HashTable k v = HashTable (Vector (Bucket k v))

-- should much more and prime
-- using small for testing
tableSize :: Int
tableSize = 10

empty :: HashTable k v
empty = HashTable (V.replicate tableSize [])

hashKey :: (Hashable k) => k -> Int
hashKey key = hashWithSalt 0 key `mod` tableSize

insert :: (Eq k, Hashable k) => k -> v -> HashTable k v -> HashTable k v
insert key value (HashTable table) = 
    HashTable $ table V.// [(index, newBucket)]
    where
        index = hashKey key
        bucket = table V.! index
        newBucket = updateBucket key value bucket

updateBucket :: Eq k => k -> v -> Bucket k v -> Bucket k v
updateBucket key value [] = [(key, value)]
updateBucket key value ((k,v):rest)
    | k == key = (key, value) : rest
    | otherwise = (k,v) : updateBucket key value rest

lookup :: (Eq k, Hashable k) => k -> HashTable k v -> Maybe v
lookup key (HashTable table) = 
    L.lookup key bucket
    where bucket = table V.! hashKey key

delete :: (Eq k, Hashable k) => k -> HashTable k v -> HashTable k v
delete key (HashTable table) =
    HashTable $ table V.// [(index, newBucket)]
    where
        index = hashKey key
        bucket = table V.! index
        newBucket = filter ((key /=) . fst) bucket

toString :: (Show k, Show v) => HashTable k v -> String
toString (HashTable table) = unlines $
    zipWith formatBucket [0..] (V.toList table)
    where
        formatBucket i bucket = 
            "Bucket[" ++ show i ++ "]: " ++ 
            unwords [show k ++ ":" ++ show v | (k,v) <- bucket]