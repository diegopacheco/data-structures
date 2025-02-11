(ns core.queue
  (:gen-class))

(defprotocol Queue
  (enqueue [this value])
  (dequeue [this])
  (front [this])
  (empty? [this])
  (to-string [this]))

(deftype QueueImpl [items]
  Queue
  (enqueue [_ value]
    (QueueImpl. (concat items (list value))))

  (dequeue [_]
    (if (seq items)
      [(first items) (QueueImpl. (rest items))]
      [nil nil]))

  (front [_]
    (first items))

  (empty? [_]
    (nil? (seq items)))

  (to-string [_]
    (str "Queue: " (vec items))))

(defn create-queue []
  (QueueImpl. '()))