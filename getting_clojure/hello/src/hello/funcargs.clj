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

; variable types
; 

(def book1 {:title "War and Peace" :author "Tolstoy"})
(def book2 {:book "Emma" :by "Austen"})
(def book3 '["1984" "Orwell"])

(defn normalize-book [book]
  (if (vector? book)
    {:title (first book) :author (second book)}
    (if (contains? book :title)
      book
      {:title (:book book) :author (:by book)}
    )))

(normalize-book book1)
(normalize-book book2)
(normalize-book book3)

; dispatch format / multi methods
(defn dispatch-book-format [book]
  (cond
    (vector? book) :vector-book
    (contains? book :title) :standard-map
    (contains? book :book) :alternative-map))

(dispatch-book-format book2)

(defmulti normalize-book2 dispatch-book-format)
(defmethod normalize-book2 :vector-book [book]
  {:title (first book) :author (second book)})
(defmethod normalize-book2 :standard-map [book]
  book)
(defmethod normalize-book2 :alternative-map [book]
  {:title (first book) :author (:by book)})


(normalize-book2 book1)
(normalize-book2 book2)
(normalize-book2 book3)

(defn notvaridic [&args]
  (println &args)
  &args)

(notvaridic 42)
