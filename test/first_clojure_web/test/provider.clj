(ns first-clojure-web.test.provider
  (:use clojure.test)
  (:require [first-clojure-web.provider :refer :all]
            [midje.sweet :refer :all]
            [conjure.core :refer :all]
            [first-clojure-web.tweet-dao :refer :all]))

(fact "get tweet"
  (stubbing [get-tweet {:tweet "This is my tweet"}]
            (is (= (tweet 3) "{\"tweet\":\"This is my tweet\"}"))) => true)
