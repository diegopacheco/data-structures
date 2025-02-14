(ns core.main
  (:require [core.bst :as bst]))

(defn -main [& args]
  (let [root (atom nil)]
    (swap! root bst/insert 50)
    (swap! root bst/insert 30)
    (swap! root bst/insert 20)
    (swap! root bst/insert 40)
    (swap! root bst/insert 70)
    (swap! root bst/insert 60)
    (swap! root bst/insert 80)

    (print "Inorder traversal of the BST: ")
    (bst/inorder-traversal @root)
    (println)

    (print "Preorder traversal of the BST: ")
    (bst/preorder-traversal @root)
    (println)

    (print "Postorder traversal of the BST: ")
    (bst/postorder-traversal @root)
    (println)

    (if (bst/search @root 40)
      (println "40 is found in the BST")
      (println "40 is not found in the BST"))

    (swap! root bst/delete-node 30)
    (print "Inorder traversal after deleting 30: ")
    (bst/inorder-traversal @root)
    (println)))