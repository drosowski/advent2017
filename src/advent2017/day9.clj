(ns advent2017.day9)

(defn groupscore [str]
    (loop [open 0
           cnt 0
           garbg false
           ignnext false
           str str]
      (cond
        (empty? str) cnt
        (and (not ignnext) (= (first str) \!)) (recur open cnt garbg true (rest str))
        (true? ignnext) (recur open cnt garbg false (rest str))
        (= (first str) \>) (recur open cnt false false (rest str))
        (true? garbg) (recur open cnt true false (rest str))
        (= (first str) \<) (recur open cnt true false (rest str))
        (= (first str) \{) (recur (inc open) cnt false false (rest str))
        (= (first str) \}) (recur (dec open) (+ cnt open) false false (rest str))
        :else (recur open cnt garbg ignnext (rest str)))))
        
        
(defn groupscore-file [filename]
    (groupscore (slurp filename)))