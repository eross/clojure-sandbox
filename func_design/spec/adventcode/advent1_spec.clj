(ns adventcode.advent1_spec
  (:require [speclj.core :refer :all]
            [func-design.core :refer :all]
            [adventcode.advent1 :refer :all]))

(def ts "1xy3z2bc")

(should= "12" (calvalue ts))

(should= "12" (calvalue "1xy34z2bc"))