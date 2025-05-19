(defn intr [sep coll]
  (drop 1 (interleave (repeat sep) coll)))

(apply str (intr \, "abc"))

(take 30 
      (for 
       [x (range 10000000) 
        y (range 10000000)
        :while (< y x)]
        [ x y]))

(def numbers [10 20 30 40 50])

(defn add2 [a b]
  (+ a b))

(reduce add2 0 numbers)

(reduce + 0 numbers)

(reduce + numbers)