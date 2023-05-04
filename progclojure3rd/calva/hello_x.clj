(ns hello_x
  (:require [clojure.core]))
(print "hello")
(comment
  (meta #'meta)
  (meta #'let)
  (meta #'str) 
  (require '[clojure.repl :as c])
  (doc meta)
  (c/doc meta)
  (meta #'+)
  (require '[clojure.core :as cc])
  (resolve 'import)
  (resolve 'resolve)
  (resolve 'cc/import)
  (resolve 'c/doc)
  (+ 1 2)
  (import '(java.io File))
  String
  java.io.File/separator
  :fcf)

(comment
  (def f [:h :t :t :h :h :h])
  :fcf)
(comment
  (let [ttt 3] ttt)
  (defn by-pairs [coll]
    (let [take-pair
          (fn [c]
            (when (next c) (take 2 c)))]
      (lazy-seq
       (when-let [pair (seq (take-pair coll))]
         (cons pair (by-pairs (rest coll)))))))

  (by-pairs f)

  :fcf)

(comment
  (print "hello")
  (def x [{:lo "foo" :id 1} {:lo "bar" :id 2} {:lo "baz" :id 3} {:lo "foo" :id 4}])
  (:lo (first x))
  (= "foo"(:lo (first x)))
  (sort-by (fn [x]
             [(= "foo" (:lo x))
              (:id x)])) 
                    
           :fcf)

