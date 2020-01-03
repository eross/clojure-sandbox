(ns my-class)

(gen-class
  :name my_class.MyClass
  :methods [[hello [] String]])

(defn -hello [this]
  "Hello, World!")
