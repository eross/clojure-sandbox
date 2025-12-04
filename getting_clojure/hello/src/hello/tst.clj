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

(def s1 '[1 2 3 4 5])
(def s2 (sorted-set 5 7 2 7))
(def s3 '[[1 2] [3 4] [5 6]])

(loop [s s1 o '()]
  (print s)
  (print o)
  (if (= (last s) nil)
    o
    (recur (pop s) (cons (last s) o))))

(conj nil 3)

(pop s1)
(last s1)
 (last [])

(conj (pop s1) (last s1) )
(cons (last s1) (pop s1) )


