(ns adventcode.advent2-spec
   (:require [speclj.core :refer :all]
            [func-design.core :refer :all]
            [clojure.string :as str]
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
(should= '("3 blue" "4 red") (split-comma-vec "3 blue, 4 red" ))
(should= '(3 "blue") (split-color-pair-seq "3 blue"))

(loop [vlst v2 res []]
  (if (empty? vlst)
    res
    (let [[num color] (first vlst)]
      (print (num))
      (recur (rest v2) (conj res (first v2))))
    )
)

(cons "1" [2])
(conj ['( 1 2)] [(first v2)])
(cons [(first v2)] '(1 2))
(empty? ())

(first v2)

(def v3(str/split (first v2) #",\s+"))
v3
(first v3)
(str/split (first v3) #"\s+")
(let [[num color] (str/split (first v3) #"\s+")] [num color])
(seq ["x" "b"])
(split-comma-vec "3 blue, 4 red")

(last '(a b c))
(def v '(3 "blue"))
(first v)
(seq ((first v)) (last v))

(def v "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")

(loop [[cl v res []]] 
  (if (empty? cl)
    res
    (recur (rest cl) (cons (first cl)))))
(str/split v #";\s+")