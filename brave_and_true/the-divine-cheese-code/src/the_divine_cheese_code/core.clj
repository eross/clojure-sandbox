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
(svg/points heists)

(defn metoo []
  42)

(defn -main
  [& args]
  (println (svg/points heists))

  *ns*

(ns-interns *ns*)
  

 (defmacro andx
   "Evaluates exprs one at a time, from left to right. If a form
   returns logical false (nil or false), and returns that value and
   doesn't evaluate any of the other expressions, otherwise it returns
   the value of the last expr. (and) returns true." 
   {:added "1.0"} 
   ([] true) 
   ([x] x) 
   ([x & next]
    `(let [andx# ~x]
       (if andx# (andx ~@next) andx#))))
  


(macroexpand '(andx 1 2 3 4)) 