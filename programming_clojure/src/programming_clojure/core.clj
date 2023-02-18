(ns programming-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!") 42) 

(comment
  (-main 123) 

  (some #(when (> % 5) %) [1 2 3 4 5 6 7 8 9 10])
  (some even? [1 2 3 4 5 6 7 8 9 10])
  (some even? [1 3 5])
  :fcf)