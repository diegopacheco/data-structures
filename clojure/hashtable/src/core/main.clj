(ns core.main
  (:gen-class)
  (:require [core.hashtable :refer :all]))

(defn -main [& args]
  (let [ht (create-hashtable)]
    (put ht "one" 100)
    (put ht "two" 200)
    (put ht "three" 300)

    (println "Initial HashTable:")
    (println (to-string ht))

    (println "\nValue for key 'two':" (get-value ht "two"))

    (println "\nRemoving key 'two'...")
    (remove-key ht "two")

    (println "\nHashTable after removal:")
    (println (to-string ht))))