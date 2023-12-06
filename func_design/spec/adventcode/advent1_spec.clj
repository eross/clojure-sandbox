(ns adventcode.advent1_spec
  (:require [speclj.core :refer :all]
            [func-design.core :refer :all]
            [clojure.string :as str]
            [adventcode.advent1 :refer :all]))

(def caldocs ["1abc2"
             "pqr3stu8vwx"
             "a1b2c3d4e5f"
             "treb7uchet"])

(def ts "1xy3z2bc")

(defn sumcalvaluesx [v]
  (loop [docs v res 0]
    (print "(first docs): ") (print (first docs)) 
    (print " res: ") (print res) (newline) 
    (if (empty? docs)
      res
      (recur (rest docs) (+ res (calvalue (first docs)))))))


(should= 12 (calvalue ts))
(should= 12 (calvalue "1xy34z2bc"))
(should= 77 (calvalue"treb7uchet"))
(should= 47 (calvalue "eight47srvbfive"))
(def x "a1b2c3d4e5f")
(should= 15 (calvalue x))

(re-seq #"\d" "eight47srvbfive")

(should= 142 (sumcalvaluesx caldocs))
rf

(rf "spec/adventcode/advent1.txt")

(sumcalvaluesx (rf "src/adventcode/advent1.txt"))

