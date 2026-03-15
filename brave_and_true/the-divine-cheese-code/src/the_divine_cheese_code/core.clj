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
  

 ;; threads
 (future (Thread/sleep 40000)
         (println "I'll print after 4 seconds"))
 (println "I'll print immediately")

 (let [result (future (println "this prints once") 
                      (+ 1 1))] 
   (println "deref: " (deref result)) 
   (println "@: " @result))

(let [result (future (Thread/sleep 3000) 
                     (+ 1 1))] 
  (println "The result is: " @result) 
  (println "It will be at least 3 seconds before I print"))

(realized? (future (Thread/sleep 1000)))

(let [f (future)]
  @f
  (realized? f))
 
 ;; delay
(def jackson-5-delay
  (delay (let [message "Just call my name and I'll be there"]
           (println "First deref: " message))))
 
(force jackson-5-delay)
@jackson-5-delay

 ;;promise
 
 (def my-promise (promise))
 (deliver my-promise (+ 1 2))
 @my-promise

(let [ferengi-wisdom-promise (promise)] 
  (future (println "Here's some Ferengi wisdom:" @ferengi-wisdom-promise)) 
  (Thread/sleep 1000) 
  (deliver ferengi-wisdom-promise "Whisper your way to success."))
