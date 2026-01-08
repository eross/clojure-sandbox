(ns ch4.core-test
  (:require [clojure.test :refer [is deftest testing]]))

(is (= (+ 1 1) 2))

(is (thrown? ArithmeticException (/ 1 0)))

(deftest my-test
  (testing "1 + 1 = 1"
    (is (= (+ 1 1) 2)))
  (testing "Ensure 2 - 1 = 1"
    (is (= (- 2 1) 1))))
