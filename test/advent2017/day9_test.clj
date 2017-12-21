(ns advent2017.day9-test
  (:require [clojure.test :refer :all]
            [advent2017.day9 :refer :all]))

(deftest groupscore-tests
    (is (groupscore "{}") 1)
    (is (groupscore "{{{}}}") 6)
    (is (groupscore "{{},{}}") 5)
    (is (groupscore "{{{},{},{{}}}}") 16)
    (is (groupscore "{<a>,<a>,<a>,<a>}") 1)
    (is (groupscore "{{<ab>},{<ab>},{<ab>},{<ab>}}") 9)
    (is (groupscore "{{<!!>},{<!!>},{<!!>},{<!!>}}") 9)
    (is (groupscore "{{<a!>},{<a!>},{<a!>},{<ab>}}") 3))