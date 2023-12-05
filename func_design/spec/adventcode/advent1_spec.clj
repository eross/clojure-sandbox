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

(should= 12 (calvalue ts))

(should= 12 (calvalue "1xy34z2bc"))
(should= 77 (calvalue"treb7uchet"))

(should= 142 (sumcalvalues caldocs))
