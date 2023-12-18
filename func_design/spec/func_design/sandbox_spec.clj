(ns func-design.sandbox-spec
  (:require 
   [speclj.core :refer :all]
   [func-design.sandbox :refer :all]))

(def str-in (atom nil))
(def str-out (atom nil))

(defn str-read []
  (let [c (first @str-in)]
    (if (nil? c)
      :eof
      (do
        (swap! str-in rest)
        c))))

(defn str-write [c]
  (swap! str-out str c)
  str-write)


(describe "copy"
          (it "can read and write using str-read and str-write"
              (reset! str-in "abcedf")
              (reset! str-out "")
              (copy str-read str-write)
              (should= "abcdef" @str-out)))