(ns advent2017.day3)

(defn spiral [len]
    (loop [x 1
           y 1
           w 2
           h 2
           step 2
           backwards false]
       (prn x y backwards w h)
        (cond
            (= step len)
                (prn "finished")
            (and (= x w) (= y 0))
                (recur (+ x 1) y (+ w 2) (+ h 2) (+ step 1) false)                
            (and (< x w) (= y 0))
                (recur (+ x 1) y w h (+ step 1) false)
            (and (< x w) (< y h) (not backwards))
                (recur (+ x 1) y w h (+ step 1) false)
            (and (= x w) (< y h))
                (recur x (+ y 1) w h (+ step 1) false)
            (and (= x w) (= y h))
                (recur (- x 1) y w h (+ step 1) true)
            (and (= x 0) (> y 0) backwards)
                (recur x (- y 1) w h (+ step 1) true)                
            (and (= x 0) (= y 0) backwards)
                (recur (+ x 1) y w h (+ step 1) false)
            (and (= x 0) (= y h) backwards)
                (recur x (- y 1) w h (+ step 1) true)
            (and (= y h) backwards)
                (recur (- x 1) y w h (+ step 1) true))))
                