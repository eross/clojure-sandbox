(ns func-design.prime)

(defn prime-factors-of-v1 [n]
  (if (> n 1)
    (if (zero? (rem n 2))
      (cons 2 (prime-factors-of-v1 (quot n 2)))
      [n])
  []))

(defn prime-factors-of [n]
  (loop [n n
         divisor 2
         factors []]
    (if (> n 1)
      (if (zero? (rem n divisor))
        (recur (quot n divisor) divisor (conj factors divisor))
        (recur n (inc divisor)factors))
      factors)))