(ns core.stack
  (:gen-class))

(defprotocol Stack
  (push [this value])
  (pop [this])
  (top [this])
  (empty? [this])
  (to-string [this]))

(deftype StackImpl [items]
  Stack
  (push [_ value]
    (StackImpl. (cons value items)))

  (pop [_]
    (if (seq items)
      (StackImpl. (rest items))
      nil))

  (top [_]
    (first items))

  (empty? [_]
    (nil? (seq items)))

  (to-string [_]
    (clojure.string/join " " items)))

(defn create-stack []
  (StackImpl. '()))