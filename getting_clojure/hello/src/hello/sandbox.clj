(ns hello.sandbox
  (:require
   [datomic.api :as d]))

(defn intr [sep coll]
  (drop 1 (interleave (repeat sep) coll)))

(apply str (intr \, "abc"))

(take 30
      (for
       [x (range 10000000)
        y (range 10000000)
        :while (< y x)]
        [x y]))

(def numbers [10 20 30 40 50])

(defn add2 [a b]
  (+ a b))

(reduce add2 0 numbers)

(reduce + 0 numbers)

(reduce + numbers)

(def at (atom 10))
(type at)
(def nat 10)
(type nat)


at
nat

(def prom (promise))

(deliver prom 44)

prom

(defn watcher [key ref old new]
  (-> (println "watched")
      (println "key:" key)
      (println "ref:" ref)
      (println "old: " old)
      (println "new: " new)))


(add-watch at :logger watcher)
; (swap! nat + 10) ; This will throw an error because 'nat' is not an atom.
(swap! at + 10)
refer
(def from 0)
(alter from - 1)

(defn xfer [to from amount]
  (dosync
   (alter from - amount)
   (alter to + amount)))

;; (def amt 60)
;; (let [t 42 f amt]
;;   (xfer t f amt)
;;   (print t f))

(ns todo-db
  (:require
   [datomic.api :as d])) (