(ns advent2017.day2-test
  (:require [clojure.test :refer :all]
            [advent2017.day2 :refer :all]))

(deftest checksum-tests
  (is (checksum '(["5" "1" "9" "5"] ["7" "5" "3"] ["2" "4" "6" "8"])) 18))