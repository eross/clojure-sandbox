(ns adventofcode.advent1
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))

(let [l '(1 2 3)] 
  (list 
   (first l) 
   (first (rest l))))


(def l2 '(1 2 3 4 5))

(take 2 l2)

(take 7 l2)

(count  l2)

(defn pairs-recursive [result n]
  (if (< (count n) 3)
    n
    (recur (conj result n)((rest(rest n))))))

(pairs-recursive [] '(1 2))

(pairs-recursive []  '(1 2 3 4))

(conj ['(8 9)] (rest (rest l2)))

(rest (rest '(1 2 3 4 5)))
(concat ['(8 9)] (rest (rest l2)))

(seq ['(1 2 3)])

(type [])
(type '())


(slurp "src/adventofcode/advent1.txt")


(defn read-numbers [filename] (->> filename
                    slurp
                    s/split-lines
                    (map #(Integer/parseInt %))))

(defn read-numbers [filename]
  (with-open [rdr (io/reader filename)]
    (->> rdr
         line-seq
         (map #(Integer/parseInt %))
         set)))


(read-numbers "src/adventofcode/advent1b.txt")

(let [numbers (read-numbers "src/adventofcode/advent1b.txt")]
  (for [a numbers
        b numbers
        :when (< a b)
        :when (= 2020 (+ a b))]
    [a b]))


(for 
 [
  a '(1 2 3)
  b '(3 4 5)]
  [a b])

(defn all [] (->> "src/adventofcode/advent1.txt"
                  slurp
                  s/split-lines
                  (map #(Integer/parseInt %))))

(all)


(defn step1 [](->> "src/adventofcode/advent1.txt"
     slurp
     s/split-lines))

(defn step2 [] (->> "src/adventofcode/advent1.txt"
                  slurp
                  s/split-lines
                  (map #(Integer/parseInt %))))

(step2)

(step1)

(defn step2 [x]
  (map #(Integer/parseInt %)))

(step2 (step1))