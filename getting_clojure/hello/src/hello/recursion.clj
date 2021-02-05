(ns hello.core)

(def books
  [{:title "Jaws" :copies-sold 2000000}
   {:title "Emma" :copies-sold 3000000}
   {:title "2001" :copies-sold 4000000}])

;this version will exhaust stack if large enough
(defn sum-copies
  ([books] (sum-copies books 0))
  ([books total]
   (if (empty? books)
     total
     (sum-copies
      (rest books)
      (+ total (:copies-sold (first books)))))))

(sum-copies books)

(defn sum-copies2
  (loop [books books total 0]
    (if (empty? books)
      total
      (recur
       (rest books)
       (+ total (:copies-sold (first books)))))))


(loop [accum [] i 0]
  (if (= i 10)
    (do  accum)

    (do
      (println accum)
      (recur (conj accum i) (inc i)))))

(def j '[1 2])

(conj j 3)

(defn fibo-recursive [n]
  (if (or (= n 0) (= n 1))
    n
    (+ (fibo-recursive (- n 1)) (fibo-recursive (- n 2)))))


(fibo-recursive 0)
(fibo-recursive 1)
(fibo-recursive 2)

(defn fibo-recur [iteration]
  (let [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    (fibo 0N 1N 0)))

(fibo-recur 6)
(fibo-recur 2000)

; From Learning Clojure Video
; 
(defn my-sum [total vals]
  (if (empty? vals)
    total
    (my-sum (+ (first vals) total) (rest vals))))


(my-sum 0 [0 1 2 3 4])

(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (my-sum (+ (first vals) total) (rest vals)))))

(my-sum [0 1 2 3 4])

(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (recur (+ (first vals) total) (rest vals)))))

(my-sum [0 1 2 3 4])

(defn my-sum [total vals]
  (if (empty? vals)
    total
    (recur (+ (first vals) total) (rest vals))))

(my-sum 0 [0 1 2 3 4])

(defn my-sum [vals]
  (loop [total 0 vals vals]
    (if (empty? vals)
      total
      (recur (+ (first vals) total) (rest vals)))))

(my-sum [0 1 2 3 4])

(reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4])

; equivalent to...
(+ (+ (+ (+ (+ 0 0) 1) 2) 3) 4)

(defn group-even [acc next-val]
  (let [key (if (even? next-val) :even :odd)]
    (update-in acc [key] #(conj % next-val))))

(group-even {} 3)
(group-even {} 4)

(reduce group-even {} [0 1 2 3 4 5 6])

(def tst (reduce group-even {} [0 1 2 3 4 5 6]))

(update-in tst [:even] conj 'foo)

; fibo -- wrong way
; 
(defn stack-consuming-fibo [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (stack-consuming-fibo (- n 1))
             (stack-consuming-fibo (- n 2)))))

(stack-consuming-fibo 1)
(stack-consuming-fibo 2)
(stack-consuming-fibo 34)

(defn tail-fibo [n]
  (letfn [(fib
          [current next n]
          (if (zero? n)
            current
            (fib next (+ current next) (dec n))))]
        (fib 0N 1N n)))

(tail-fibo 34)
(tail-fibo 6)

(tail-fibo 10000)

; better
(defn recur-fibo [n]
  (letfn[(fib
          [current next n]
          (if(zero? n)
          current
          (recur next (+ current next)(dec n))))]
   (fib 0N 1N n)))

(recur-fibo 900)


;lazy

(defn lazy-seq-fibo
  ([]
   (concat [0 1](lazy-seq-fibo 0N 1N)))
  ([a b]
   (let [n (+ a b)]
     (lazy-seq
      (cons n (lazy-seq-fibo b n))))))

(lazy-seq-fibo)

(take 10 (lazy-seq-fibo))
(rem (nth (lazy-seq-fibo) 1000000)1000)

(take 5 (iterate (fn [[a b]][b (+ a b)])[0 1]))


