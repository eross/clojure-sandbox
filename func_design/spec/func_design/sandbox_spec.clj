(ns func-design.sandbox-spec
  (:require 
   [speclj.core :refer :all]
   [clojure.test.check :as tc]
   [clojure.test.check.properties :as prop]
   [clojure.test.check.generators :as gen]
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
              (reset! str-in "abcdef")
              (reset! str-out "")
              (copy str-read str-write)
              (should= "abcdef" @str-out)))



;=====================

(defn factors-of [n]
  (loop [factors [] n n divisor 2]
    (if (> n 1)
      (cond
        (> divisor (Math/sqrt n))
        (conj factors n)
        (= 0 (mod n divisor))
        (recur (conj factors divisor)
               (quot n divisor)
               divisor)
        :else
        (recur factors n (inc divisor)))
      factors)))

(defn power2 [n]
  (apply * (repeat n 2N)))


(describe "factor primes"
          (it "factors 1 -> []"
              (should= [] (factors-of 1)))
          (it "factors 2 -> [2]"
              (should= [2] (factors-of 2)))
          (it "factors 3 -> [2]"
              (should= [3] (factors-of 3)))
          (it "factors 4 -> [2 2]"
              (should= [2 2] (factors-of 4)))
          (it "factors 5 -> [5]"
              (should= [5] (factors-of 5)))
          (it "factors 6 -> [2 3]"
              (should= [2 3] (factors-of 6)))
          (it "factors 7 -> [7]"
              (should= [7] (factors-of 7)))
          (it "factors 8 -> [2 2 2]"
              (should= [2 2 2] (factors-of 8)))
          (it "factors 9 -> [3 3]"
              (should= [3 3] (factors-of 9)))
          (it "factors lots"
              (should= [2 2 3 3 5 7 11 11 13]
                       (factors-of (* 2 2 3 3 5 7 11 11 13))))
          (it "factors Euler 3"
              (should= [71 839 1471 6857] (factors-of 600851475143)))

          (it "factors mersenne 2^31-1"
              (should= [2147483647] (factors-of (dec (power2 31))))))

(run-specs)

;===============

(def gen-inputs (gen/large-integer* {:min 1 :max 1E9}))

(declare n)

(describe "properties"
          (it "multiplies out properly"
              (should-be
               :result
               (tc/quick-check
                1000
                (prop/for-all
                 [n gen-inputs] 
                 (let [factors (factors-of n)]
                   (= n (reduce * factors))))))))