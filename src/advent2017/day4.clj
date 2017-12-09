(ns advent2017.day4
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn duplicates? [xs]
  (not= (count (distinct xs)) (count xs)))

(defn passcheck [lines]
  (loop [lines lines
         valid 0]
    (let [line (first lines)
          words (.split line " ")
          nvalid (if (duplicates? words)
                    valid
                    (+ valid 1))]
      (if (nil? (next lines))
        nvalid
        (recur (next lines) nvalid)))))

(defn passcheck-file [filename]
  (with-open [rdr (io/reader filename)]
         (passcheck (line-seq rdr))))
