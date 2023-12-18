(ns func-design.sandbox
  (:require [clojure.string :as str]))

(defn copy [read write]
  (let [c (read)]
    (if (= c :eof)
      nil
      (recur read (write c)))))




