(ns hello.core)

(def books 
  [{:title "Jaws" :copies-sold 2000000}
   {:title "Emma" :copies-sold 3000000}
   {:title "2001" :copies-sold 4000000}])

;this version will exhaust stack if large enough
(defn sum-copies
  ([books] (sum-copies books 0))
  ([books total]
   (if (empty? books)
     total
     (sum-copies
      (rest books)
      (+ total (:copies-sold (first books)))))))

(sum-copies books)

(defn sum-copies2
  (loop [books books total 0]
   (if (empty? books)
     total
     (recur
      (rest books)
      (+ total (:copies-sold (first books))))))
  )