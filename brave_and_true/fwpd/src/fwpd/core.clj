(ns fwpd.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def filename "suspects.csv")

(slurp filename)

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))





; Source - https://stackoverflow.com/q
; Posted by Mr.Queries, modified by community. See post 'Timeline' for change history
; Retrieved 2025-12-30, License - CC BY-SA 3.0

(-> (java.io.File. ".") .getAbsolutePath)


