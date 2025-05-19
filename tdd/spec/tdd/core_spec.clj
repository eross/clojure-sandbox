(ns tdd.core-spec
  (:require [speclj.core :refer :all]
            [tdd.core :refer [foo]]))

(comment ((describe "a test"
                    (it "FIXME, I fail."
                        (should= 0 1)))))


(describe "hello"
          (it "foo"
              (should= 43 (foo))))

(sort
 (distinct
  (take 10000
        (repeatedly #(rand-int 10)))))


(count
 (for [i [1 2 3 4 12] j [5 6 7 8]]
   [i j]))

(defn lg
  ([x y] (if (> x y) x y))
  ([x y & m] (apply lg (lg x y) m)))


(require '[clojure.core :as core])

(source core/+)

(defn fibs
  []
  (map first
       (iterate (fn [[a b]] [b (+ a b)]) [0 1])))
(take 10(fibs))

(take 10 (iterate inc 4))

(defn x [[a b]] [b (+ a b)])
(x [3 4])