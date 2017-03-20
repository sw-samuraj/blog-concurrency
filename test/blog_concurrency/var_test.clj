(ns blog-concurrency.var-test
  (:require [midje.sweet :refer :all]
            [blog-concurrency.var :refer :all]))

(fact "static binding throws an exception"
  (binding [static-var "re-binded var"] static-var) =>
      (throws IllegalStateException))

(fact "dynamic var can be re-binded"
  re-binded-var => "re-binded var")

(fact "root binding is still untouched"
  *dynamic-var* => "dynamic var")

(fact "vars are global"
  future-var => "future var")
