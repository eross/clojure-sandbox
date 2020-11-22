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

(def counter (ref 0))

(defn next-counter [] (dosync (alter counter inc)))

(next-counter)

(deref counter)


;; agents

(def counter (agent 0))

(send counter inc)

(deref counter)

(await (send counter inc))
(await-for 1000 (send counter inc))
