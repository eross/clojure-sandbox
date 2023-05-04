(ns concurrency)

(comment
  (ref 'initial-state)
  (def current-track (ref "Mars, the Bringer of War"))
  (deref current-track)
  @current-track
  (dosync (ref-set current-track "Eric the bringer of code"))

  (def messages (ref ()))

  (defn bad-add-message [msg]
    (dosync (ref-set messages (cons msg @messages))))
  
 (defn add-message [msg]
   (dosync (alter messages conj msg)))
  
  @messages

  (add-message "hi")

  @messages
  :fcf
  )
