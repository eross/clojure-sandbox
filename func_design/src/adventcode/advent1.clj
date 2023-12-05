(ns adventcode.advent1
  (:require [clojure.string :as str]
            )
)



(defn calvalue1 [s]
  (str/join "" (re-seq #"\d+" s)))

(defn calvalue [s]
  (let [res (re-seq #"\d+" s)]
    (str/join(concat (first res) (last res)))))

(def f (calvalue "1xy3z2bc"))
f
(str/join "" f)
(first caldoc)

(def f (first caldoc))

f
(seq f)

(str/join "" (re-seq #"\d+" f))