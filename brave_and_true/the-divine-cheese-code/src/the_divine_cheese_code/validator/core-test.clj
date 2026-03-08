(ns the-divine-cheese-code.validator.core-test
  (:require [clojure.test :refer [deftest is testing run-tests]]
            [the-divine-cheese-code.validator.core :refer [valid-email? validate-user]]))

;; ---------------------------------------------------------------------------
;; valid-email? unit tests
;; ---------------------------------------------------------------------------

(deftest valid-email?-test
  (testing "accepts well-formed email addresses"
    (is (valid-email? "alice@example.com"))
    (is (valid-email? "user.name+tag@sub.domain.org"))
    (is (valid-email? "USER@EXAMPLE.COM"))
    (is (valid-email? "u@x.io"))
    (is (valid-email? "firstname.lastname@company.co.uk")))

  (testing "rejects malformed email addresses"
    (is (not (valid-email? "missing-at-sign")))
    (is (not (valid-email? "@no-local-part.com")))
    (is (not (valid-email? "no-domain@")))
    (is (not (valid-email? "missing-tld@domain")))
    (is (not (valid-email? "spaces in@email.com")))
    (is (not (valid-email? "double@@at.com"))))

  (testing "rejects non-string inputs"
    (is (not (valid-email? nil)))
    (is (not (valid-email? 42)))
    (is (not (valid-email? :keyword)))
    (is (not (valid-email? [])))))

;; ---------------------------------------------------------------------------
;; validate-user — missing fields
;; ---------------------------------------------------------------------------

(deftest validate-user-missing-fields-test
  (testing "both fields absent (empty map)"
    (let [{:keys [valid? errors]} (validate-user {})]
      (is (false? valid?))
      (is (= 2 (count errors)))
      (is (some #(re-find #"Name" %) errors))
      (is (some #(re-find #"Email" %) errors))))

  (testing "nil values treated as missing"
    (let [{:keys [valid? errors]} (validate-user {:name nil :email nil})]
      (is (false? valid?))
      (is (= 2 (count errors)))))

  (testing "blank strings treated as missing"
    (let [{:keys [valid? errors]} (validate-user {:name "   " :email ""})]
      (is (false? valid?))
      (is (= 2 (count errors)))))

  (testing "only :name missing"
    (let [{:keys [valid? errors]} (validate-user {:email "alice@example.com"})]
      (is (false? valid?))
      (is (= 1 (count errors)))
      (is (re-find #"Name" (first errors)))))

  (testing "only :email missing"
    (let [{:keys [valid? errors]} (validate-user {:name "Alice"})]
      (is (false? valid?))
      (is (= 1 (count errors)))
      (is (re-find #"Email" (first errors))))))

;; ---------------------------------------------------------------------------
;; validate-user — invalid email (field present but bad format)
;; ---------------------------------------------------------------------------

(deftest validate-user-invalid-email-test
  (testing "name present, email malformed"
    (let [{:keys [valid? errors]} (validate-user {:name "Alice" :email "not-an-email"})]
      (is (false? valid?))
      (is (= 1 (count errors)))
      (is (re-find #"invalid" (first errors)))))

  (testing "does NOT emit both 'required' and 'invalid' for bad email"
    (let [{:keys [errors]} (validate-user {:name "Alice" :email "bad"})]
      (is (= 1 (count errors)))))

  (testing "does NOT emit email-invalid error when email is simply missing"
    (let [{:keys [errors]} (validate-user {:name "Alice"})]
      (is (every? #(not (re-find #"invalid" %)) errors)))))

;; ---------------------------------------------------------------------------
;; validate-user — happy path
;; ---------------------------------------------------------------------------

(deftest validate-user-valid-test
  (testing "valid name and email returns no errors"
    (let [{:keys [valid? errors]} (validate-user {:name "Alice" :email "alice@example.com"})]
      (is (true? valid?))
      (is (empty? errors))))

  (testing "valid with subdomain email"
    (is (true? (:valid? (validate-user {:name "Bob" :email "bob@mail.company.org"})))))

  (testing "valid with plus-addressed email"
    (is (true? (:valid? (validate-user {:name "Carol" :email "carol+news@example.com"}))))))

;; ---------------------------------------------------------------------------
;; Run all tests (REPL convenience)
;; ---------------------------------------------------------------------------

(comment
  (run-tests 'the-divine-cheese-code.validator.core-test)

  ;; run all tests
  )