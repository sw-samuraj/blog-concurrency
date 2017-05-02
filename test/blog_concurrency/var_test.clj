(ns blog-concurrency.var-test
  (:require [clojure.test :refer :all]
            [blog-concurrency.var :refer :all]))

(deftest test-static-var-binding
  (testing "static binding throws an exception"
    (is (thrown? IllegalStateException
                 (binding [static-var "re-binded var"] static-var)))))

(deftest test-dynamic-var-binding
  (testing "dynamic var can be re-binded"
    (is (= "re-binded var" re-binded-var)))
  (testing "root binding is still untouched"
    (is (= "dynamic var" *dynamic-var*)))
  (testing "vars are global"
    (is (= "future var" future-var))))

(deftest test-dynamic-fn-binding
  (testing "The Answer to the Ultimate Question of Life, The Universe, and Everything"
    (is (= 42 (compute))))
  (testing "the answer in binary form"
    (is (= "101001" (compute-binary)))))
