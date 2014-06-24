(ns first-clojure-web.test.dao_test
  (:require [first-clojure-web.dao :refer :all]
            [midje.sweet :refer :all]))

(fact "testing dao"
      (contains? (insertData {:test "test"}) "OK"))
