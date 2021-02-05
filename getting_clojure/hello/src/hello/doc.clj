(ns hello.core
  (:use clojure.repl))
;(use 'clojure.repl)

;(if (>= (.compareTo (clojure-version) "1.3.0") 0)
;  (do (use 'clojure.repl)
;      (use 'clojure.java.javadoc)))
(clojure-version)

(defn x2 
    "Return 2x"
  [x]
  (+ x x))

(doc x2)

(x2 3)

(doc sum-copies)

doc