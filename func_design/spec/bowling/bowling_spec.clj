(ns bowling.bowling-spec
  (:require [speclj.core :refer :all]
            [func-design.core :refer :all]
            [bowling.bowling :refer [score]]))

(should= 0 (score (repeat 20 0)))

(should= 20 (score (repeat 20 1)))

;; spares
(should= 24 (score (concat [5 5 7] (repeat 17 0))))

;; strikes
(should= 20 (score (concat [10 2 3] (repeat 16 0))))