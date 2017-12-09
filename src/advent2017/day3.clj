(ns advent2017.day3)

(defn spiral [len]
    (loop [x 1
           y 0
           min -1
           max 1
           step 2
           expand false]
	(let [nstep (+ step 1)]
        (prn x y "   " min max step)
          (cond
            (= step len)
              (prn (+ (Math/abs x) (Math/abs y)))
            (true? expand)
              (recur x (+ y 1) (- min 1) (+ max 1) nstep false)
            (and (< x max) (= y min))
              (recur (+ x 1) y min max nstep false)
            (and (= x max) (= y min))
              (recur (+ x 1) y min max nstep true)
            (and (= x max) (< y max))
              (recur x (+ y 1) min max nstep false)
            (and (> x min) (= y max))
              (recur (- x 1) y min max nstep false)
            (and (= x min) (> y min))
              (recur x (- y 1) min max nstep false)))))
