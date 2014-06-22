(ns first-clojure-web.test.provider
  (:require [first-clojure-web.provider :refer :all]
            [midje.sweet :refer :all]))

(fact "hello world"
      (helloworld {:name "my name"}) => "{\"user\":\"my name\"}")

(fact "Add function check"
      (custom-add 2 2) => 4)
