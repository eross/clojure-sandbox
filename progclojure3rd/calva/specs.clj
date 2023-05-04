(ns specs
  (:require [clojure.spec.alpha :as s]) 
  )

(s/def :my.app/company-name string?)

(s/valid? :my.app/company-name "Acme Moving")

(s/valid? :my.app/company-name 101)

(s/def :marble/color #{:red :green :blue})

(s/valid? :marble/color :yello)

(s/int-in 0 11)

(s/def ::ranged-roll (s/int-in 0 11))

(s/def ::odd-int (s/and int? odd?))
(s/valid? ::odd-int 5)

(s/valid? ::odd-int 4)
(s/explain ::odd-int 4)
