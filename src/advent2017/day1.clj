(ns advent2017.day1)

(defn- sumequal [digits]
    (loop [sum 0
           pos 0]
        (let [left (nth (cycle digits) pos)
              right (nth (cycle digits) (+ pos 1))]
            (if (>= pos (count digits))
                sum
                (if (= left right)
                    (recur (+ sum left) (+ pos 1))                
                    (recur sum (+ pos 1)))))))
                    

(defn invcapt [digits]
    (sumequal (map (fn [char] (Character/digit char 10)) (seq digits))))
    