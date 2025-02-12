(ns core.hashtable
  (:gen-class))

(defprotocol HashTable
  (put [this k v])
  (get-value [this k])
  (remove-key [this k])
  (to-string [this]))

(deftype HashTableImpl [^:volatile-mutable table]
  HashTable
  (put [_ k v]
    (let [hash-code (mod (.hashCode k) 10)
          bucket (get table hash-code [])]
      (set! table
            (assoc table hash-code
                   (cons [k v]
                         (remove #(= (first %) k) bucket))))))

  (get-value [_ k]
    (let [hash-code (mod (.hashCode k) 10)
          bucket (get table hash-code [])]
      (second (first (filter #(= (first %) k) bucket)))))

  (remove-key [_ k]
    (let [hash-code (mod (.hashCode k) 10)
          bucket (get table hash-code [])]
      (set! table
            (assoc table hash-code
                   (remove #(= (first %) k) bucket)))))

  (to-string [_]
    (letfn [(format-bucket [idx bucket]
              (str "Bucket[" idx "]: "
                   (clojure.string/join " "
                                        (map #(str "(" (first %) ":" (second %) ")") bucket))))]
      (clojure.string/join "\n"
                           (map-indexed format-bucket (for [i (range 10)] (get table i [])))))))

(defn create-hashtable []
  (HashTableImpl. {}))