(ns bowling.bowling)


(defn to-frames[rolls]
  (let [frames (partition 2 rolls)
        possible-bonuses (map #(take 1 %) (rest frames))
        possible-bonuses (concat possible-bonuses [[0]])]
    (map concat frames possible-bonuses)))

(defn add-frame [score frame-and-bonus]
  (let [frame (take 2 frame-and-bonus)]
    (if (= 10 (reduce + frame))
      (+ score (reduce + frame-and-bonus))
      (+ score (reduce + frame)))))


(defn score [rolls]
  (reduce add-frame 0 (to-frames rolls)))



