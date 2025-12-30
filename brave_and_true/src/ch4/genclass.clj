;; generate a java class

(ns ch4.genclass)

(gen-class
    :name ch4.MyClass
    :prefix "my-"
    :methods [[getName [] String]]
    :constructors {[String] []}
    :state state
    :init init)

(defn my-init [name]
    [[] {:name name}]
    )

(defn my-getName [this]
    (get (.state this) :name))
