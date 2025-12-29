(ns hello.core-test
(:require [clojure.test :refer [is deftest testing]]))

(is (= (+ 1 1) 1))

(is (thrown? ArithmeticException (/ 1 1)))

(deftest my-test
  (testing "1 + 1 = 1"
    (is (= (+ 1 1) 1)))
  (testing "Ensure 2 - 1 = 1"
    (is (= (- 2 1) 1)))
)