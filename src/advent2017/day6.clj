(ns advent2017.day6)

(defn memblock [block]
  (loop [block block
         pastblocks []
         step 1]
     (let [mx (apply max block)
           mxidx (.indexOf block mx)
           incr (int (Math/ceil (/ mx (count block))))
           nblock (map-indexed (fn [idx elem]
                      (if (= idx mxidx)
                      (- elem (* (dec (count block)) incr))
                      (+ incr elem))) block)]
        (prn nblock)
        (if (> (.indexOf pastblocks nblock) -1)
          step
          (recur nblock (conj pastblocks nblock) (inc step))))))
