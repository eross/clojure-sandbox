(ns hello.core)
; arity functions
(defn greet
  ([to-whome](println "Welcome to " to-whome))
  ([message to-whome](println message to-whome)))

(greet "Eric")

(greet "This is my message" "Eric")

(defn greet2
  ([to-whome](greet "Welcome home" to-whome))
  ([message to-whome](println message to-whome)))

(greet2 "Send me to" "Eric")

(greet2 "Eric")

;varidic function
(defn print-any-args [& args]
  (println "The args are: " args))

(print-any-args "This" "is" 42)