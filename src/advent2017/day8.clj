(ns advent2017.day8
  (:require [clojure.java.io :as io]
            [clojure.core.match :refer [match]]))

(defn put-if-absent [m k v]
  (if (contains? m k)
    m
    (assoc m k v)))

(defn test-value [m k test tval]
  (let [val (m k)]
    (match [test]
      ["=="] (= val tval)
      ["!="] (not (= val tval))
      :else  ((load-string test) val tval))))

(defn performop [m k op amount]
  (if (= "inc" op)
    (update m k + (Integer/valueOf amount))
    (update m k - (Integer/valueOf amount))))

(defn reginst [insts]
  (loop [insts insts
         regs {}]
    (let [inst (first insts)
          [id op amount] (.split inst " ")
          conds (.split (.trim (get (.split inst "if") 1)) " ")
          [testid, test, testval] conds
          nregs (put-if-absent regs id 0)
          nregs (put-if-absent nregs testid 0)]
          (if (nil? (next insts))
            (apply max (vals (performop nregs id op amount)))
            (if (test-value nregs testid test (Integer/valueOf testval))
              (recur (rest insts) (performop nregs id op amount))
              (recur (rest insts) nregs))))))

(defn reginst-file [filename]
  (with-open [rdr (io/reader filename)]
     (reginst (line-seq rdr))))
