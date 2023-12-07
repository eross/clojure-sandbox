(ns adventcode.advent2
  (:require [clojure.string :as str]))

(defn getgames [v]
  (let [[id colors] (str/split v #":\s+")]
    (let [runs (str/split colors #";\s+")]
      )
    (cons id [colors])
    )
  )

(defn split-comma-seq [v]
  (str/split v #",\s+"))