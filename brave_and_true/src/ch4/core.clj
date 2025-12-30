(ns ch4.core)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, ch4!"))

(defn square [x]
  (* x x))

(square 5)

(def x (seq [1 2 3]))

(instance? clojure.lang.IEditableCollection x)

(def y {:a 1 :b 2 :c 3})

(into {} y)

(map + [1 2 3] [4 5 6])

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))

(defn doit [a b] (+ a b))

(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])

(stats [80 1 44 13 6])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])


(map :real identities)

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

(assoc (assoc {} :max (inc 30))
       :min (inc 10))

;; lazy seqs

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true :name "Mickey Mouse"}})

(Thread/sleep 1000)
(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))


(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(time (vampire-related-details 0))

(time (def mapped-details (map vampire-related-details (range 0 1000000))))

;;(time (map vampire-related-details (range 0 5)))

;;;(first mapped-details)
;;(time (first mapped-details))

;;; Don't do this.  Causes to evaluate all values
;;; (count mapped-details)

;;;(ns-unmap *ns* 'mapped-details)

(take 8 (repeat "na"))

(take 3 (repeatedly (fn [] (rand-int 10))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(print "Load of ch4 complete\n")