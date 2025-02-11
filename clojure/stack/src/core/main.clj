(ns core.main
  (:gen-class)
  (:require [core.stack :refer :all]))

(defn -main [& args]
  (let [stack (-> (create-stack)
                  (push 300)
                  (push 200)
                  (push 100))]

    (println (to-string stack))
    (println "Top:" (top stack))

    (let [stack2 (pop stack)]
      (println "Pop:" (top stack))

      (let [stack3 (pop stack2)]
        (println "Pop:" (top stack2))
        (println (str "Stack is " (if (empty? stack3) "empty" "not empty")))
        (println (to-string stack3))))))