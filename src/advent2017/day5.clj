(ns advent2017.day5)

(defn maze [coll]
  (loop [coll coll
         idx 1
         step 1]
     (let [val (nth coll (- idx 1))
           nval (+ val 1)
           leftcol (take (- idx 1) coll)
           rightcol (nthrest coll idx)
           ncoll (doall (flatten (list leftcol nval rightcol)))]
        (if (nil? (nth coll (+ (- idx 1) val) nil))
          step
          (recur ncoll (+ idx val) (+ step 1))))))
