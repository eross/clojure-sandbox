;; generate a java class

(ns hello.genclass)

(gen-class
    :name hello.MyClass
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