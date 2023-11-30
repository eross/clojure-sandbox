(ns tdd.core-spec
  (:require [speclj.core :refer :all]
            [tdd.core :refer [foo]]))

(comment ((describe "a test"
            (it "FIXME, I fail."
                (should= 0 1)))))


(describe "hello"
          (it "foo"
              (should= 43 (foo))))