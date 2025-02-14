(ns core.bst)

(defrecord Node [data left right])

(defn create-node [data]
  (Node. data nil nil))

(defn insert [root data]
  (if (nil? root)
    (create-node data)
    (if (< data (:data root))
      (assoc root :left (insert (:left root) data))
      (if (> data (:data root))
        (assoc root :right (insert (:right root) data))
        root))))

(defn find-min [root]
  (if (nil? root)
    nil
    (if (nil? (:left root))
      root
      (find-min (:left root)))))

(defn delete-node [root data]
  (if (nil? root)
    nil
    (if (< data (:data root))
      (assoc root :left (delete-node (:left root) data))
      (if (> data (:data root))
        (assoc root :right (delete-node (:right root) data))
        (if (nil? (:left root))
          (:right root)
          (if (nil? (:right root))
            (:left root)
            (let [temp (find-min (:right root))
                  new-data (:data temp)]
              (assoc root
                     :data new-data
                     :right (delete-node (:right root) new-data)))))))))

(defn search [root data]
  (if (nil? root)
    false
    (if (= data (:data root))
      true
      (if (< data (:data root))
        (search (:left root) data)
        (search (:right root) data)))))

(defn inorder-traversal [root]
  (if (nil? root)
    nil
    (do
      (inorder-traversal (:left root))
      (print (:data root) " ")
      (inorder-traversal (:right root)))))

(defn preorder-traversal [root]
  (if (nil? root)
    nil
    (do
      (print (:data root) " ")
      (preorder-traversal (:left root))
      (preorder-traversal (:right root)))))

(defn postorder-traversal [root]
  (if (nil? root)
    nil
    (do
      (postorder-traversal (:left root))
      (postorder-traversal (:right root))
      (print (:data root) " "))))