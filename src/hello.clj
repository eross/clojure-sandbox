(ns hello
  (:require [my-class])
  (:import (my_class MyClass)))

(defn -main [& args]
  (let [inst (MyClass.)]
    (println (.hello inst))))
