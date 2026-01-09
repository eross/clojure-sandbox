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

(convert :glitter-index 3)


; Source - https://stackoverflow.com/q
; Posted by Mr.Queries, modified by community. See post 'Timeline' for change history
; Retrieved 2025-12-30, License - CC BY-SA 3.0

(-> (java.io.File. ".") .getAbsolutePath)

; The parse function takes a string and first splits 
; it on the newline character to create a seq of strings. 
; Next, it maps over the seq of strings, splitting each one 
; on the comma character. Try running parse on your CSV:


(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

; The next bit of code takes the seq of vectors
; and combines it with your vamp keys to create maps:

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))



