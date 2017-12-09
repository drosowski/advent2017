(ns advent2017.day4-test
  (:require [clojure.test :refer :all]
            [advent2017.day4 :refer :all]))

(deftest passcheck-tests
  (is (passcheck ["foo bar" "bar foo"]) 2)
  (is (passcheck ["foo foo" "bar foo"]) 1)
  (is (passcheck ["foo foo" "bar bar"]) 0))
