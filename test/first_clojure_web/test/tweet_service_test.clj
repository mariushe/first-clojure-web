(ns first-clojure-web.test.tweet-service-test
  (:use clojure.test)
  (:require [first-clojure-web.tweet-service :as tweet-service]
            [midje.sweet :refer :all]
            [conjure.core :refer :all]
            [first-clojure-web.tweet-dao :as tweet-dao]))

(fact "get tweets"
  (stubbing [tweet-dao/get-tweets {:tweet "This is my tweet"}]
            (is (= (tweet-service/get-tweets) {:tweet "This is my tweet"}))) => true)
