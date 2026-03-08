(ns the-divine-cheese-code.validator.core
  (:require [clojure.string :as str]))

;; Email validation regex
(def email-regex #"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")

(defn valid-email? [email]
  (and (string? email)
       (re-matches email-regex email)))

(defn validate-user
  "Validates a map with :name and :email fields.
   Returns a map with :valid? boolean and :errors vector."
  [data]
  (let [errors (cond-> []
                 ;; Check :name presence
                 (str/blank? (str (:name data)))
                 (conj "Name is required")

                 ;; Check :email presence
                 (str/blank? (str (:email data)))
                 (conj "Email is required")

                 ;; Check :email validity (only if present)
                 (and (not (str/blank? (str (:email data))))
                      (not (valid-email? (:email data))))
                 (conj "Email is invalid"))]

    {:valid?  (empty? errors)
     :errors  errors}))


;; --- Example Usage ---
(comment
  (validate-user {})
  ;; => {:valid? false, :errors ["Name is required" "Email is required"]}

  (validate-user {:name "Alice" :email "not-an-email"})
  ;; => {:valid? false, :errors ["Email is invalid"]}

  (validate-user {:name "Alice" :email "alice@example.com"})
  ;; => {:valid? true, :errors []}

  (validate-user {:name "" :email "alice@example.com"})
  ;; => {:valid? false, :errors ["Name is required"]}
  )