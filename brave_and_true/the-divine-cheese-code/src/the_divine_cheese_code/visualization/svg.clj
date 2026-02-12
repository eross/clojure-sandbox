(ns the-divine-cheese-code.visualization.svg)

(defn latlng->point
  "Convert lat/lng map to comma separated string"
  (latlng)
  (str (:lng latlng) "," (:lat latlng)))

