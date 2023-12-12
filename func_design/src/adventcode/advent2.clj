(ns adventcode.advent2
  (:require [clojure.string :as str]))

(defn getgames [v]
  (let [[id colors] (str/split v #":\s+")]
    (let [runs (str/split colors #";\s+")]
      )
    (cons id [colors])
    )
  )

(defn split-comma-vec [v]
  (seq(str/split v #",\s+")))

(defn split-color-pair-seq [v]
  (let [[num color] (str/split v #"\s+")] 
    (list (Long/parseLong num) (keyword color))
      )
)
  