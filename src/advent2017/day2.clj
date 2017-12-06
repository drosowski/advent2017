(ns advent2017.day2
    (:require [clojure.data.csv :as csv]
              [clojure.java.io :as io]))


(defn checksum [csv]
    (loop [data csv
           sum 0]
        (let [row (first data)
              numrow (map read-string row)
              maxval (apply max numrow)
              minval (apply min numrow)
              rowsum (- maxval minval)]
            (if (= (count data) 1)
                (+ sum rowsum)
                (recur (rest data) (+ sum rowsum))))))
              
(defn- readcsvfile [filename]    
    (with-open [reader (io/reader filename)]
        (doall
            (csv/read-csv reader))))

(defn checksumfile [filename]
    (prn (readcsvfile filename)))
