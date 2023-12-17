(ns adventcode.advent2-spec
   (:require [speclj.core :refer :all]
            [func-design.core :refer :all]
            [clojure.string :as str :refer :all]
            [adventcode.advent2 :refer :all]))

(def samples
  ["Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
   "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
   "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
   "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
   "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"])

(str/split (first samples) #":\s+" )

(def g1 (getgames (first samples)))

g1
(should= '["Game 1" "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"] (str/split (first samples) #":\s+") )
(def g1 (str/split (first samples) #":\s+"))
(should= '("Game 1" "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green" ) (getgames  (first samples)))       
(should= '("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green") (rest (getgames (first samples))))

(cons "xxx" ["yyy" "fff"])
(def v "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
v
(def v2 (str/split v #";\s+"))
v2
(seq v2)
(count v2)
(nth v2 2)
(seq [(nth v2 2)])
(split-comma-vec (nth v2 2))
(defn col-pairs [p]
  (loop [pairs p res []]
    (if (empty? pairs)
      res
      (recur (rest pairs) (())))))


(map (seq v2) #(split-comma-vec %1) )

(map  #(split-comma-vec (seq [%])) v2)
(should= '("3 blue" "4 red") (split-comma-vec "3 blue, 4 red" ))
(should= '(3 :blue) (split-color-pair-seq "3 blue"))

;=======
str/split
(def a {})
(map  )

(loop [vlst v2 res []]
  (if (empty? vlst)
    res
    (let [[num color] (first vlst)]
      (print (num))
      (recur (rest v2) (conj res (first v2))))
    )
)
str/split


str/split
(first v2)
str/split
(def v3(str/split (first v2) #",\s+"))
v3
(first v3)
(str/split (first v3) #"\s+")
(let [[num color] (str/split (first v3) #"\s+")] [num color])
(seq ["x" "b"])
(split-comma-vec "3 blue, 4 red")
(def v4 (split-comma-vec "3 blue, 4 red"))
v4
(last '(a b c))
(def v '("3" "blue"))
(first v)
(conj (last v) (first v))

(def v "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
v
(def v2 (str/split v #";"))
(conj ['(2 3) '(4 5)] '(4 5))
(conj (conj nil '(4 5)) '(9 8))

;("3 blue" "4 red")
v4
(split-color-pair-seq (first v4))
(def tpair
(loop [cl v4 res nil]
  (println cl)
  (if (empty? cl)
    res
    (recur (rest cl) (conj res (split-color-pair-seq(first cl)))))))
tpair
(def x '(3 :blue))
(def y '((4 :red)))
y
x
(cons tpair)
(merge tpair)
(concat tpair)
(def flatpair (flatten tpair))
flatpair
(def allpairs '((4 :red)(3 :blue)(7 :pink) (6 :rec)))

allpairs

