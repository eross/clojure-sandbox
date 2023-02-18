(defrecord Person
  [fname;; first name
   lname ;; last name
   ])

(defrecord Recipe
  [name ;; string
   author ;; recipe creator
   description ;; string
   ingredients ;; list of ingredients
   steps ;; sequence of string
   servings ;; number of servings
   ])

(->Person "eric" "ross")

(def toast
  (->Recipe
      "Toast"
      (->Person "Alex" "Miller") ;; nested
      "Crispy bread"
      ["Slice of bread"]
      ["Toast bread in toaster"]
      1))
(:author toast)

(defrecord Tst [a b])
(def tst nil)

(ns-unmap (find-ns 'user) 'tst)

