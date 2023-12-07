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
(str/split v #";\s+")

(cons 1 [2])

