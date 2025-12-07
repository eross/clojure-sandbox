(+ 16r09 1)

10r(+ 16r9 10r1)
   

(+ 16r0c 32rbb)

(bit-shift-right 128 1)

(count '( 1 2 3 3 1))

(def nums '(1 2 3 4 5))

(reduce + nums)

(last nums)
(first nums)
(rest nums)

(do
(let [cnt 0
      x1 (first nums)
      x2 (rest nums)] 
  (print "count" cnt))
)


(loop [n nums]
  (if (> (count n) 1) 
    (recur (rest n))
    n))

(first 
(loop [n nums c 3]
  (if (> c 1)
    (recur (rest n) (dec c))
    n)))


 (loop [n nums c 0]
   (if (= n '())
     c
     (recur (rest n) (inc c))
     ))

nums
(def x 42)
(dec x)
(rest nums)

(def y '(1))
(rest y)
(= (rest y) '())
 
 ;; problem 22
 (fn [x] (loop [n x c 0]
           (if (= n '())
             c
             (recur (rest n) (inc c)))))

(inc 3)

;Problem 23, Reverse a Sequence

(def s0 '())
(def s1 '[1 2 3 4 5])
(def s2 (sorted-set 5 7 2 7))
(def s3 '[[1 2] [3 4] [5 6]])

(loop [s s1 o '()] 
  (if (= (first s) nil)
    o
    (recur (rest s) (cons (first s) o))))

 (fn [x] 
          (loop [s x o '()]
            (if (= (first s) nil)
              o
              (recur (rest s) (cons (first s) o))))
 )

(conj nil 3)

(pop s1)
(last s1)
 (last [])

(conj (pop s1) (last s1) )
(cons (last s1) (pop s1) )
(cons (last s1) s0)


(rest s1)
 
 ; problem 24, Sum It All Up

 (def s1 [2 4 6 8]
   )

(def s2 0)
(+ s2 (first s1))
(= (first '()) nil)
(loop [n s1 s 0]
  (if (= (first n) nil)
    s
    (recur (rest n) (+ s (first n)))))\

(fn [x]
  (loop [n x s 0]
    (if (= (first n) nil)
      s
      (recur (rest n) (+ s (first n))))))\

; problem 25, Find the Odd Numbers
(def s1 [1 2 3 4 5 6 7 8 9 10])
 
(filter odd? s1)

(fn [x]
  (filter odd? x))

(loop [n s1 o '()]
  (if (= (first n) nil)
    o
    (if (odd? (first n))
      (recur (rest n) (conj o (first n)))
      (recur (rest n) o))))



;Problem 26, Fibonacci Sequence
(vector 3)
(cons 3 [1 1])

 (loop [m 10 l 1 c 2 s '[1 1]]
   (println "l" l)
   (println "c" c)
   (println "s" s)
   (if (> c m)
     (reverse s)
     (recur m c (+ l c) (cons c s))))

(fn [x] 
  (loop [m x l 1 c 2 s '[1 1]] 
    (if (>= c m)
      (reverse s)
      (recur m c (+ l c) (cons c s)))))

 
(
 (fn [x]
   (loop [m (- x 2) l 1 c 2 s '[1 1]]
     (if (= m 0)
       (reverse s)
       (recur (- m 1) c (+ l c) (cons c s)))))
 6)

;problem 27 -- palindrome detector
(def s1 '(1 2 3 2 1))
(def s2 '(1 2 3 4 5))
(def s3 '())
(def s4 "abcd")
(seq s4)
(seq s1)
(reverse s4)
()
(fn [x]
  (= (seq x) (reverse x)))

;Problem 28, Flatten a Sequence
(def s1 '((1 2) (3 4) 5 6))
(def s2 '(1 (2 (3 nil nil) (4 nil nil)) (5 (6 nil nil) nil)))
(tree-seq list? rest s2)



(flatten s2)

(tree-seq s1)
(first s1)

(def t '((1 2 (3)) (4)))
;;=> #'user/t

;; Here the tree-seq uses 'sequential?' as the 'branch?' predicate.
;; This causes the 'children' function to run for any collection.
;; The 'seq' ('children') function recurses on all items in the collection.
;; This results in a sequence of sub-trees, rooted at each node.
(tree-seq sequential? seq t)
;;=> (((1 2 (3)) (4))
;;    (1 2 (3)) 1 2 
;;    (3) 3 (4) 4)

(defn flattenx [x]
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq x))))
(flattenx t)

(sequential? '(1 2))
(sequential? 3)
(seq t)

(tree-seq sequential? seq t)
(rest (tree-seq sequential? seq t))
(def t2 (rest (tree-seq sequential? seq t)))

(tree-seq sequential? seq t)
(println t2)
(println "t" t)
(println "t2" t2)

(def fs
  {:name "/"
   :type :dir
   :children [{:name "home"
               :type :dir
               :children [{:name "alice" :type :dir :children []}
                          {:name "bob.txt" :type :file}]}
              {:name "etc" :type :dir :children []}]})

(tree-seq
 #(and (map? %) (= (:type %) :dir) (seq (:children %)))  ; branch?
 :children                                                ; children fn
 fs)

;; Returns every node in depth-first order:
;; => ({:name "/", :type :dir, :children [...]}
;;     {:name "home", ...}
;;     {:name "alice", ...}
;;     {:name "bob.txt", ...}
;;     {:name "etc", ...})

(def t3 '((1 2 (3)) (4)))

(tree-seq seq? identity t3)
;(((1 2 (3)) (4)) 
; (1 2 (3)) 
; 1 2 
; (3) 
; 3 
; (4) 
; 4)

(def mystring "eric")
(seq mystring)

; Problem 29, Get the Caps

(def s1 "HeLlO WoRlD!")
(def s2 "nothing")
(def s3 "$#A(*&987Zf")

(def ss [s1 s2 s3])
ss


#(clojure.string/replace % #"[^A-Z]" "")


(def lwcset
  (set
   (map char
        (range
         (int \A)
         (inc (int \Z))))))
(fn [s]
  (apply str
         (filter
          (set
           (map char
                (range
                 (int \A)
                 (inc (int \Z)))))
          s)))


(apply str (filter lwcset s1))

(map
 (fn [s]
   (apply str
          (filter
           (set
            (map char
                 (range
                  (int \A)
                  (inc (int \Z)))))
           s)))
 ss
 
 )
;-----

(def squares (map #(* % %) (range)))

(take 10 squares)