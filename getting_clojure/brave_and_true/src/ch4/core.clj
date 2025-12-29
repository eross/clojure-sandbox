(ns ch4.core)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

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

