(ns advent2017.day6)

(defn memblock [block]
  (loop [block block
         pastblocks []
         step 1]
     (let [mx (apply max block)
           mxidx (.indexOf block mx)
           nblock (loop [nblock (assoc block mxidx 0)
                         idx mxidx
                         incr mx]
                    (let [nidx (if (>= (inc idx) (count nblock))
                                  0
                                  (inc idx))]
                      (if (= incr 0)
                        nblock
                        (recur (update-in nblock [nidx] inc) nidx (dec incr)))))]
        (if (> (.indexOf pastblocks nblock) -1)
          step
          (recur nblock (conj pastblocks nblock) (inc step))))))
