(ns advent2017.day1-test
  (:require [clojure.test :refer :all]
            [advent2017.day1 :refer :all]))

(deftest invcapt-tests
  (is (invcapt "1111" ) 4)
  (is (invcapt "1122" ) 3)
  (is (invcapt "1234" ) 0)
  (is (invcapt "91212129" ) 9))