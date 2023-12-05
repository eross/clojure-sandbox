(ns adventcode.advent1
  (:require [clojure.string :as str]
            )
)

(def caldoc [
             "1abc2"
             "pqr3stu8vwx"
             "a1b2c3d4e5f"
             "treb7uchet"
])

(defn calvalue [s]
  (str/split s #""))

(first caldoc)

(def f (first caldoc))

(str/split f #"")

(str/split f #"\s+")