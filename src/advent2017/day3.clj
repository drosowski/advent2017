(ns advent2017.day3)

(defn spiral [len]
    (loop [x 1
           y 1
           w 2
           h 2
           step 2
           backwards false
           expand false]
       (prn x y backwards  step w h)
        (cond
            (= step len)
                (prn "finished")
            (and (= x w) (= y 0) (not expand))
                (recur (+ x 1) y (+ w 2) (+ h 2) (+ step 1) false true)                
            (and (< x w) (= y 0))
                (recur (+ x 1) y w h (+ step 1) false expand)
            (and (< x w) (< y h) (not backwards))
                (recur (+ x 1) y w h (+ step 1) false false)
            (and (= x w) (< y h))
                (recur x (+ y 1) w h (+ step 1) false false)
            (and (= x w) (= y h))
                (recur (- x 1) y w h (+ step 1) true false)
            (and (= x 0) (> y 0) backwards)
                (recur x (- y 1) w h (+ step 1) true false)                
            (and (= x 0) (= y 0) backwards)
                (recur (+ x 1) y w h (+ step 1) false false)
            (and (= x 0) (= y h) backwards)
                (recur x (- y 1) w h (+ step 1) true false)
            (and (= y h) backwards)
                (recur (- x 1) y w h (+ step 1) true false))))
                