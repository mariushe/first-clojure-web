(ns first-clojure-web.tweet-service
  (:require [first-clojure-web.tweet-dao :as tweet-dao]
            [clojure.data.json :as json]))

(def get-tweets (fn[] (tweet-dao/get-tweets)))

(def save-tweet (fn[tweet] (tweet-dao/save-tweet tweet)))
