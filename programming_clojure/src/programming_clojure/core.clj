(ns programming-clojure.core
  (:import 'java.io.File)
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!") 42)

(comment
  (import 'java.io.File)
  (-main 123)

  (some #(when (> % 5) %) [1 2 3 4 5 6 7 8 9 10])
  (some even? [1 2 3 4 5 6 7 8 9 10])
  (some even? [1 3 5])
  (some #(even? %) [1 5 3])
  (seq
   (.listFiles (File. ".")))

  (count
   (map #(.getName %)
        (seq
         (.listFiles (File. ".")))))
  #{1 2 3}
  :fcf)

(comment
  
  (def f (first (.listFiles (File. "."))))
  f 
  (defn millis-to-minutes [ms] (/ ms 1000 60.0))
  (millis-to-minutes 60000)
  (/ (.lastModified f) 1000 1000.0 60)
  (millis-to-minutes (.lastModified f))
  :fcf
  )

(comment
  (def c '(a b c 1 2 3)) 

  (peek c)
  (first c)
  (pop c)
  (rest c)
 (let [x (pop c)
      y (peek c)]
      [ x y] ) 
  :fcf)

(comment
  (def ht '[:h :t :h :h :h])
  (defn by-pairs [coll]
    (let [ take-pair (fn [c]
                       (when (next c)(take 2)))]
    (lazy-seq
     (when-let [pair (seq (take-pair coll))]
       (cons pair (by-pairs (rest coll)))))
    ))
  (by-pairs ht)
  :fcf)

(comment
  (defn msg
    ([] (println "Hello There") 'done)
    ([name] (print "Hello " name) 'done2)
  )
  
  (msg)
  (msg 'Eric)
  :fcf)

(comment
  (def file 42)
  (.toString file)
  (clojure.core/str file)

  ;; More destructuring with a string
  (let [[first-char second-char & rest-of-chars] "abcde"]
    (prn 'first= first-char)
    (prn 'second= second-char)
    (prn 'rest= rest-of-chars)
    (prn (.toString rest-of-chars)))

  ;; Destructuring, getting the first character of a string
;; and then a reference to the entire string
  (let [[first-char :as all-the-string] "abcde"]
    (prn 'first= first-char)
    (prn 'all= all-the-string))
  :fcf
  )

(comment
  ;; fp -- how to be lazy
  ;; wrong way to do it -- consume stack
  (defn stack-consuming-fibo [n]
    (cond
      (= n 0) 0
      (= n 1) 1
      :else (+ (stack-consuming-fibo (- n 1))
      (stack-consuming-fibo (- n 2)))))
  (stack-consuming-fibo 10)

  ;;tail recursion
(defn tail-fibo [n]
  (letfn[(fib
          [current next n]
          (if (zero? n)
            current
            (fib next (+ current next)(dec n))))]
    (fib 0N 1N n)))
  (tail-fibo 1000)
  (count (.toString (tail-fibo 1000)))

;; recur
  (defn recur-fibo [n]
    (letfn [(fib
              [current next n]
              (if (zero? n)
                current
                (recur next (+ current next) (dec n))))]
      (fib 0N 1N n)))
  (recur-fibo 100000)
  :fcf
  )

(comment
  *ns*
  (find-ns 'programming-clojure.core)
  (= *ns* (find-ns 'programming-clojure.core))
  (ns-unmap *ns* 'c)
  (ns-unmap *ns* 'take-pair)
  c
  (def h '[:h :t :t :h :h :h])

  (defn by-pairs [c]
    (let [take-pair (take-pairx c)] take-pair))


  (by-pairs h)

  (lazy-seq
   (when-let [pair (seq (take-pair c2))] pair))


  ((by-pairs h))
  (defn take-pairx [c]
    (when (next c) (take 2 c)))
  (def c h)
  (when-let [pair (seq (take-pair c))]
    (cons pair (rest c)))

  (class (take-pair h)) ;lazy-seq
  (class (seq (take-pair h))) ;cons
  
  (lazy-seq h)


  :fcf
  )