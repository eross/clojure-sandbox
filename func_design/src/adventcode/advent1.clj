(ns adventcode.advent1
  (:require [clojure.string :as str]
            ))

(defn calvalue [s]
  (let [res (re-seq #"\d+" s)]
    ;(print (Long/parseLong (str/join(concat (first res) (last res)))))
   ; (spit "advent1.log"
   ;       (str
   ;        (str/join (concat (first res) (last res))) "\n") :append true)
    ;(Long/parseLong (str/join (concat (first res) (last res)))))
  (Long/parseLong (if (= (count res) 2)
    (str/join (concat (first res) (last res)))
    (first res)))
  ))

(defn sumcalvalues [v]
  (loop [docs v res 0]
    (if (empty? docs)
      res
      (recur (rest docs) (+ res (calvalue (first docs))))))
  )

(defn readfile [s]
  (str/split-lines (slurp s))
  )

(defn rf [s]
  (str/split-lines (slurp s)))


(defn main []
       (print (sumcalvalues (readfile "advent1.txt" ))))

