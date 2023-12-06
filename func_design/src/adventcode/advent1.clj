(ns adventcode.advent1
  (:require [clojure.string :as str]))

(defn calvalue [s]
  (let [res (re-seq #"\d" s)]
     (Long/parseLong (if (>= (count res) 2)
                      (str/join (concat (first res) (last res)))
                      (str/join (concat(first res)(first res)))))))     

(defn sumcalvalues [v]
  (loop [docs v res 0]
    (if (empty? docs)
      res
      (recur (rest docs) (+ res (calvalue (first docs)))))))

(defn rf [s]
  (str/split-lines (slurp s)))


(defn main []
  (print (sumcalvalues (rf "advent1.txt"))))

