(ns adventofcode.advent2
  (:require [clojure.string :as s]))


(def sample-input "1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc")


()


(defn passwords [filename]
  (->> filename
       slurp
       s/split-lines))

(passwords "src/adventofcode/advent2.txt")


(->>(range)
 (map #(* % %))
 (take 10))



