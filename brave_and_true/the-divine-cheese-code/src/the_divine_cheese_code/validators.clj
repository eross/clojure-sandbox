(ns the-divine-cheese-code.validators
  (:require [clojure.string :as str]))


(defn valid-email?
  "Simple but practical email validation"
  [s]
  (and s
       (string? s)
       (re-matches #"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" s)))

(defn validate-user
  "Validates a user map with :name and :email.
   Returns nil if valid, otherwise returns a map of errors."
  [user]
  (let [errors (cond-> {}
                 (not (contains? user :name))
                 (assoc :name "Missing :name")

                 (and (contains? user :name)
                      (or (not (string? (:name user)))
                          (str/blank? (:name user))))
                 (assoc :name "Name must be a non-empty string")

                 (not (contains? user :email))
                 (assoc :email "Missing :email")

                 (and (contains? user :email)
                      (not (valid-email? (:email user))))
                 (assoc :email "Invalid email format"))]
    (when (seq errors)
      errors)))

;; Alternative version: throwing version (more common in some contexts)
(defn validate-user!
  "Throws ex-info if validation fails, returns the user map if valid"
  [user]
  (when-let [errors (validate-user user)]
    (throw (ex-info "User validation failed"
                    {:type   :validation-error
                     :errors errors
                     :input  user})))
  user)

;; Usage examples:

(comment
  (validate-user {:name "Eric" :email "eric@example.com"})
  ;; → nil (valid)

  (validate-user {:name "Eric"})
  ;; → {:email "Missing :email"}

  (validate-user {:name "" :email "not-an-email"})
  ;; → {:name "Name must be a non-empty string"
  ;;    :email "Invalid email format"}

  (validate-user {:name "Eric" :email "bob@company"})
  ;; → {:email "Invalid email format"}

  ;; With throwing version:
  (try
    (validate-user! {:name "Alice" :email "alice@valid.com"})
    (catch clojure.lang.ExceptionInfo e
      (ex-data e)))
  ;; → nil (success) or {:type :validation-error, :errors {...}}
  )
