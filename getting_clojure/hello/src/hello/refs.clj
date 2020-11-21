(defrecord Message [sender text])

(->Message "Eric" "Hi There")

(def messages (ref ()))

(defn add-message [msg]
    (dosync (alter messages conj msg)))


;; This one fails -- no transaction running
(alter messages conj (->Message "Tom" "Bye"))

(dosync (alter messages conj (->Message "Tom" "Bye")))

(add-message (->Message "Tim" "Waving"))

(add-message (->Message "Pete" "Shouting"))