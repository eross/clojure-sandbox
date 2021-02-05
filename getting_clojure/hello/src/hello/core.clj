(ns hello.core)

*clojure-version*
(defn square [x]
  (* x x x))

(square 3)

(defn pow [n p]
  (Math/pow n p))

;;(println "Hello World")

(/ 100 1)

(def v (vector "a" "b" 'c))
(do (println v)v)

(def xx v)
(def xx ('a 'b 'c))
(do
;;(println xx)
xx)

;;(println(rest v))



(rest(rest (rest v)))

(v 2)
(vec v)
(seq v)
(list v)

(conj v v)

(def poems '(​"Iliad"​ ​"Odyssey"​ ​"Now We Are Six"​))
(def vectorpoems '["Iliad"​ ​"Odyssey"​ ​"Now We Are Six"​])

["Iliad" "Odyssey" "Now We Are Six"]

(conj poems "jabberwocky")
(conj vectorpoems "jabberwocky")
(conj poems v)

(conj v poems)
(concat v poems)

[1 2 3]

(def mymap {:name "Eric" :age 42 :classes ["cs100" "cs102"]})

(mymap :name)

(def mymapnoclasses (dissoc mymap :classes))
mymapnoclasses

(def myset #{:foods "food" "bread" "carrots"})


(set (concat myset #{"food"}))
(contains? myset "food")
(myset "food")
(myset "foodx")
(:foods myset)

(set '("a" "a" "b" "a"))

;(def error #{a a a})

(def myset2 #{:drinks "water" "beer" "juice"})

(conj myset "bread")
(conj myset "chocolate")
(conj myset myset2)

(disj myset "bread")

;; arrays

(def myarray (into-array ["this" "is" "an" "array"]))

(aget myarray 2)

(amap myarray idx ret (aset ret idx (apply str (reverse (aget myarray idx)))))

(reverse (aget myarray 2))
(apply str (aget myarray 2))

(areduce myarray idx ret (long 0) (+ ret (count (aget myarray idx))))