(ns advent2017.day5-test
  (:require [clojure.test :refer :all]
            [advent2017.day5 :refer :all]))

(deftest maze-tests
  (is (maze [0 3 0 1 -3]) 5))
