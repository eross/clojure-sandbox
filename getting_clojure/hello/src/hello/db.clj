(ns hello.core)
(require '[clojure.java.jdbc :as jdbc])
(def conn {:dbtype "derby" :dbame "./books" :create true})

(def db {:dbtype "derby" :dbame "./books"})

(jdbc/query db ["select * from books"])

