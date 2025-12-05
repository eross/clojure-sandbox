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
