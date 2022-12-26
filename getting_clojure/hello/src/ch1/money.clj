(ns ch1.money)

(declare validate-same-currency)
(defrecord Currency [divisor sym desc])

(defrecord Money [amount ^Currency currency]
  java.lang.Comparable
  (compareTo [m1 m2]
    (validate-same-currency m1 m2)
    (compare (:amount m1) (:amount m2))))

(def currencies {:usd (->Currency 100 "USD" "US Dollars")
                 :eur (->Currency 100 "EUR" "Euro")})

(comment
  (defrecord Point [x y])
  (Point. 1 2)
  (.x (Point. 3 4))

  (defrecord NamedPoint [^String name ^long x ^long y])
  (NamedPoint. "first" 3 4)
  (NamedPoint/getBasis)
  (map meta (NamedPoint/getBasis))

 java.lang.Comparable 
  java.lang.Comparable (.compareTo 4 3)
  
  (def mypoint (->Point 22 33))
  mypoint
  (meta mypoint)
  (def mypoint2 (map->Point {:x 22 :y 33}))
  mypoint2

  

  :fcf)


(comment
  (defn- validate-same-currency [m1 m2]
    (or (= (:sym m1) (:sym m2))
        (throw
         (ex-info "Currencies do not match."
                  {:m1 m1 :m2 m2}))))
  (defn =$
    ([m1] true)
    ([m1 m2] (zero? (java.lang.Comparable (.compareTo m1 m1))))
    ([m1 m2 & monies]
     (every? zero? (map #(.compareTo m1 %)(conj monies m2)))))
  
  
  (=$ m1)
  (=$ m1 m2)
  m1
  m2
  (:sym m1)
  (validate-same-currency m1 m2)
  :fcf)

(comment
  (def m1 (:usd currencies))
  (def m2 (:eur currencies))
  :fcf)

(:usd currencies)
(:eur currencies)


(validate-same-currency (:usd currencies) (:eur currencies))

(comment
  ;---
; Excerpted from "Clojure Applied",
; published by The Pragmatic Bookshelf.
; Copyrights apply to this code. It may not be used to create training material, 
; courses, books, articles, and the like. Contact us if you are in doubt.
; We make no guarantees that this code is fit for any purpose. 
; Visit http://www.pragmaticprogrammer.com/titles/vmclojeco for more book information.
;---
;
(ns ch1.money)

(declare validate-same-currency)

(defrecord Currency [divisor sym desc])

(defrecord Money [amount ^Currency currency]
  java.lang.Comparable
  (compareTo [m1 m2]
    (validate-same-currency m1 m2)
    (compare (:amount m1) (:amount m2))))

(def currencies {:usd (->Currency 100 "USD" "US Dollars")
                 :eur (->Currency 100 "EUR" "Euro")})
;

;
(defn- validate-same-currency
  [m1 m2]
  (or (= (:currency m1) (:currency m2))
      (throw
       (ex-info "Currencies do not match."
                {:m1 m1 :m2 m2}))))

(defn =$
  ([m1] true)
  ([m1 m2] (zero? (.compareTo m1 m2)))
  ([m1 m2 & monies]
   (every? zero? (map #(.compareTo m1 %) (conj monies m2)))))

(defn +$
  ([m1] m1)
  ([m1 m2]
   (validate-same-currency m1 m2)
   (->Money (+ (:amount m1) (:amount m2)) (:currency m1)))
  ([m1 m2 & monies]
   (reduce +$ m1 (conj monies m2))))

(defn *$ [m n] (->Money (* n (:amount m)) (:currency m)))
;

;
(defn make-money
  ([] (make-money 0))
  ([amount] (make-money amount :usd))
  ([amount currency] (->Money amount currency)))
;

(defn -$ [m1 m2 & monies])

(defn allocate [m proportions])

(def zero-dollars (make-money 0 :usd))

  
  :fcj)

(comment
  (make-money)
  (make-money 1)
  (make-money 5 (:eur currencies))
  :fcj)