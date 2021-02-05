(ns hello.core)

(defn preferred-customer [preferred]
  (if preferred 
    (println "You are preferred")
    (println "You are not preferred")))

(preferred-customer true)
(preferred-customer false)

(do
  (println "Hello 1")
  (println "Hello 2")
  (println "Hello 3")
  (println "Hello 4")
  44
  )

(defn shipping-charge [preferred-customer order-amount]
  (if preferred-customer
    (do
      (println "Preferred, free shipping")
      0.0)
    (do(println "Regular customer. Regular shipping")
     (* order-amount 0.10))))

(shipping-charge true 200)
(shipping-charge false 200)

(defn shipping-charge2 [preferred-customer order-amount]
  (cond
    preferred-customer 0.0
    (< order-amount 50.0) 5.0
    (< order-amount 100.0) 10.0
    (>= order-amount 100.0) (* 0.1 order-amount)
    :else 42)
  )

(shipping-charge2 true 200)
(shipping-charge2 false 74)