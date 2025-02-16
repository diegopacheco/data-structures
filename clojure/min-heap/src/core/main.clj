(ns core.main
  (:require [core.heap :refer [create-min-heap insert extract-min get-min print-heap]]))

(defn -main []
  (let [heap (-> (create-min-heap 10)
                 (insert 3)
                 (insert 2)
                 (insert 15)
                 (insert 5)
                 (insert 4)
                 (insert 45))]

    (print-heap heap)
    (println (str "Minimum element: " (get-min heap)))
    (println (str "Extracted min: " (extract-min heap)))
    (print-heap heap)))