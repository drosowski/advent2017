(ns advent2017.day6-test
  (:require [clojure.test :refer :all]
            [advent2017.day6 :refer :all]))

(deftest memblock-tests
  (is (memblock [0 2 7 0]) 5))
