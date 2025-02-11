(ns core.main
  (:gen-class)
  (:require [core.queue :refer :all]))

(defn -main [& args]
  (let [queue (-> (create-queue)
                  (enqueue 100)
                  (enqueue 200)
                  (enqueue 300))]
    (println (to-string queue))
    (println "Front element:" (front queue))

    (let [[value1 queue2] (dequeue queue)]
      (println "Dequeued:" value1)

      (let [[value2 queue3] (dequeue queue2)]
        (println "Dequeued:" value2)
        (println (str "Queue is " (if (empty? queue3) "empty" "not empty")))
        (println (to-string queue3))))))