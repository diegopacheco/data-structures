(ns core.main
  (:gen-class)
  (:require [core.list :refer :all]))

(defn -main [& args]
  (let [lst (-> (create-list)
                (add 50)
                (add 40)
                (add 30)
                (add 20)
                (add 10))]
    (println (to-string lst))

    (let [lst2 (remove-value lst 40)]
      (println (to-string lst2))

      (let [search-value 4]
        (println (str search-value " "
                      (if (contains? lst search-value)
                        "found"
                        "not found")
                      " in the list"))))))