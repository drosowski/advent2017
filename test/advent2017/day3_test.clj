(ns advent2017.day3-test
  (:require [clojure.test :refer :all]
            [advent2017.day3 :refer :all]))

(deftest checksum-tests
  (is (spiral 1) 1)
  (is (spiral 123) 10)
  (is (spiral 253) 12))
