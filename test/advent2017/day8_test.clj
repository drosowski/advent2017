(ns advent2017.day8-test
  (:require [clojure.test :refer :all]
            [advent2017.day8 :refer :all]))

(deftest reginst-tests
  (is (reginst ["a inc 1 if b < 5" "b inc 5 if a != 1" "b inc 5 if c < 1"]) 5))
