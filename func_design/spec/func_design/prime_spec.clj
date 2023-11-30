(ns func-design.prime-spec
  (:require [speclj.core :refer :all]
            [func-design.core :refer :all]
            [func-design.prime :refer [prime-factors-of]]))

(comment
  (describe "a test"
            (it "FIXME, I fail."
                (should= 1 1)))
  :axx
  )

(should= [] (prime-factors-of 1))

(should= [2] (prime-factors-of 2))

(should= [3] (prime-factors-of 3))

(should= [2 2] (prime-factors-of 4))

(should= [2 2 2] (prime-factors-of 8))

(should= [3 3](prime-factors-of 9))

(should= [2 3 3](prime-factors-of 18))