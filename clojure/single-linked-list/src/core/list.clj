(ns core.list
  (:gen-class))

(defprotocol LinkedList
  (add [this value])
  (remove-value [this value])
  (contains? [this value])
  (to-string [this]))

(deftype Node [value next])

(deftype LinkedListImpl [head]
  LinkedList
  (add [this value]
    (LinkedListImpl. (Node. value head)))

  (remove-value [this value]
    (letfn [(remove-rec [current]
              (cond
                (nil? current) nil
                (= (.value current) value) (.next current)
                :else (Node. (.value current) (remove-rec (.next current)))))]
      (LinkedListImpl. (remove-rec head))))

  (contains? [this value]
    (loop [current head]
      (cond
        (nil? current) false
        (= (.value current) value) true
        :else (recur (.next current)))))

  (to-string [this]
    (loop [current head
           result []]
      (if (nil? current)
        (clojure.string/join " " (reverse result))
        (recur (.next current)
               (conj result (.value current)))))))

(defn create-list []
  (LinkedListImpl. nil))