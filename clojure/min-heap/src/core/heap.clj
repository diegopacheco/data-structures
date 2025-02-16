(ns core.heap)

(defprotocol MinHeap
  (insert [this value])
  (extract-min [this])
  (get-min [this])
  (print-heap [this]))

(defn- parent [i]
  (quot (dec i) 2))

(defn- left [i]
  (+ (* 2 i) 1))

(defn- right [i]
  (+ (* 2 i) 2))

(defn- swap! [arr i j]
  (let [temp (aget arr i)]
    (aset arr i (aget arr j))
    (aset arr j temp)))

(defn- heapify-up [arr index]
  (loop [idx index]
    (when (pos? idx)
      (let [parent-idx (parent idx)]
        (when (< (aget arr idx) (aget arr parent-idx))
          (swap! arr idx parent-idx)
          (recur parent-idx))))))

(defn- heapify-down [arr index size]
  (loop [idx index]
    (let [l (left idx)
          r (right idx)
          smallest (cond
                     (and (< l size)
                          (< (aget arr l) (aget arr idx)))
                     l
                     (and (< r size)
                          (< (aget arr r) (aget arr idx)))
                     r
                     :else idx)]
      (when (not= smallest idx)
        (swap! arr idx smallest)
        (recur smallest)))))

(deftype MinHeapImpl [^:volatile-mutable arr ^:volatile-mutable size]
  MinHeap
  (insert [this value]
    (aset arr size value)
    (set! size (inc size))
    (heapify-up arr (dec size))
    this)

  (extract-min [this]
    (when (pos? size)
      (let [min-val (aget arr 0)]
        (aset arr 0 (aget arr (dec size)))
        (set! size (dec size))
        (when (pos? size)
          (heapify-down arr 0 size))
        min-val)))

  (get-min [this]
    (when (pos? size)
      (aget arr 0)))

  (print-heap [this]
    (print "Min Heap:")
    (doseq [i (range size)]
      (print (str " " (aget arr i))))
    (println)))

(defn create-min-heap [capacity]
  (->MinHeapImpl (make-array Integer/TYPE capacity) 0))