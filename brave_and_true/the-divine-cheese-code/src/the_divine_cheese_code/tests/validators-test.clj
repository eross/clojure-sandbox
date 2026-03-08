(ns the-divine-cheese-code.tests.validators-test
  (:require [clojure.test :refer [deftest is testing run-tests]]
            [clojure.string :as str]
            [the-divine-cheese-code.validators :refer [valid-email? validate-user]]))

;; ──────────────────────────────────────────────────────────────────────────────
;; Helper: valid-email?
;; ──────────────────────────────────────────────────────────────────────────────

(deftest test-valid-email?
  (testing "valid email formats"
    (is (true? (valid-email? "alice@example.com")))
    (is (true? (valid-email? "bob.smith+tag@sub.domain.co.uk")))
    (is (true? (valid-email? "a@b.c")))
    (is (true? (valid-email? "user123@company.io"))))

  (testing "invalid or problematic email formats"
    (is (false? (valid-email? nil)))
    (is (false? (valid-email? "")))
    (is (false? (valid-email? "   ")))
    (is (false? (valid-email? "no-at-sign")))
    (is (false? (valid-email? "@domain.com")))
    (is (false? (valid-email? "user@")))
    (is (false? (valid-email? "user@domain")))
    (is (false? (valid-email? "user@domain.")))
    (is (false? (valid-email? "user@-domain.com")))
    (is (false? (valid-email? "user@domain-.com")))
    (is (false? (valid-email? "very.long.but.still.valid@sub.sub.sub.domain.example.co.uk")))))

;; ──────────────────────────────────────────────────────────────────────────────
;; Main validator: validate-user
;; ──────────────────────────────────────────────────────────────────────────────

(deftest test-validate-user
  (testing "completely valid input → returns nil"
    (is (nil? (validate-user {:name "Eric Ross" :email "eric@example.com"})))
    (is (nil? (validate-user {:name "A" :email "a@b.co"}))))

  (testing "missing fields"
    (is (= {:name "Missing :name"}
           (validate-user {:email "test@example.com"})))

    (is (= {:email "Missing :email"}
           (validate-user {:name "Alice"})))

    (is (= {:name "Missing :name"
            :email "Missing :email"}
           (validate-user {})))

    (is (= {:name "Missing :name"
            :email "Missing :email"}
           (validate-user nil))))

  (testing "invalid name"
    (is (= {:name "Name must be a non-empty string"}
           (validate-user {:name "" :email "ok@example.com"})))

    (is (= {:name "Name must be a non-empty string"}
           (validate-user {:name "   " :email "ok@example.com"})))

    (is (= {:name "Name must be a non-empty string"}
           (validate-user {:name 42 :email "ok@example.com"}))))

  (testing "invalid email"
    (is (= {:email "Invalid email format"}
           (validate-user {:name "Bob" :email "invalid"})))

    (is (= {:email "Invalid email format"}
           (validate-user {:name "Bob" :email "bob@company"})))

    (is (= {:email "Invalid email format"}
           (validate-user {:name "Bob" :email "@example.com"}))))

  (testing "multiple errors are reported together"
    (is (= {:name "Name must be a non-empty string"
            :email "Invalid email format"}
           (validate-user {:name "" :email "bad"})))

    (is (= {:name "Missing :name"
            :email "Invalid email format"}
           (validate-user {:email "no-at"})))))

;; Run all tests when this file is loaded / evaluated
(comment
  (run-tests)
  ;; or more conveniently in rich comment form:
  ;; (clojure.test/run-tests 'user.validators-test)
  )

;; Optional: if you want a quick way to see if everything passes
(defn run-all-tests []
  (run-tests 'the-divine-cheese-code.tests.validators-test))

(comment
  (run-all-tests)
  ;; → All tests should pass with no failures or errors.
  )