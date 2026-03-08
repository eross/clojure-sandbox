(ns the-divine-cheese-code.core
  (:gen-class))

(require ['the-divine-cheese-code.visualization.svg :as 'svg])
;;(refer 'the-divine-cheese-code.visualization.svg)

(def heists [{:location "Cologne, Germany"
              :cheese-name "Archbishop Hildebold's Cheese Pretzel"
              :lat 50.95
              :lng 6.97}
             {:location "Zurich, Switzerland"
              :cheese-name "The Standard Emmental"
              :lat 47.37
              :lng 8.55}
             {:location "Marseille, France"
              :cheese-name "Le Fromage de Cosquer"
              :lat 43.30
              :lng 5.37}
             {:location "Zurich, Switzerland"
              :cheese-name "The Lesser Emmental"
              :lat 47.37
              :lng 8.55}
             {:location "Vatican City"
              :cheese-name "The Cheese of Turin"
              :lat 41.90
              :lng 12.45}])


(defn -main
  [& args]
  (println (svg/points heists)))

(defmacro backwards
  [form]
  (reverse form))

(backwards (" backwards" " am" "I" str))

(def addition-list (list + 1 2))
addition-list

(eval addition-list)

(concat '(3) [10])
(concat addition-list [10])
(eval (concat addition-list [10]))


;; infix notation

(defmacro infix
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))


(infix (1 + 2))


(macroexpand
 '(when true
    'a
    'b))


(defmacro andprime
  "Evaluates exprs one at a time, from left to right. If a form
  returns logical false (nil or false), and returns that value and
  doesn't evaluate any of the other expressions, otherwise it returns
  the value of the last expr. (and) returns true."
  {:added "1.0"}
  ([] true)
  ([x] x)
  ([x & next]
   `(let [and# ~x]
      (if and# (and ~@next) and#))))

(macroexpand '(andprime 'a true 'b))
(macroexpand
 '(and 'a true 'b))


;; prevent evaluation in macro.
(defmacro my-print
  [expression]
  (list 'let ['result expression]
        (list 'println 'result)
        'result))
(my-print "hello")

(macroexpand '(my-print "hello"))

;; when
(defmacro whenprime
  "Evaluates test. If logical true, evaluates body in an implicit do."
  {:added "1.0"}
  [test & body]
  (list 'if test (cons 'do body)))

(macroexpand '(whenprime true
                         (println "This is true")
                         (println "This is also true")))

(ns-unmap *ns* 'when)
`+

`notdefined_here

;; Using ~ to force evaluation in quoted list
`(+ 1 ~(inc 1))

;; generate a symbol in a macro

(gensym 'myvar)

;; shortcut for gensym
`(myvar#)

;; fun with doseq
(map list [1 2 3] [1 2 3])
(doseq [[x y] (map list [1 2 3] [1 2 3])]
  (prn (* x y)))

(doseq [[x y] (map list [1 2 3] [1 2 3])]
  (println x y))

(doseq [[x y] (list [1 2 3] [3 4 5])] (println x y))
(doseq [x [1 2 3] y [3 4 5]] (println x y))

(list [1 2 3] [1 2 3])