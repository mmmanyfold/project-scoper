(ns project-scoper.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [project-scoper.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
