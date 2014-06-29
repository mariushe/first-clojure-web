(ns first-clojure-web.tweet-dao
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(defn get-tweets []
  (let [conn (mg/connect)
        db   (mg/get-db conn "myTweet")]
    (mc/find-maps db "tweet")))

(defn save-tweet [tweet]
  (let [conn (mg/connect)
        db   (mg/get-db conn "myTweet")]
    (mc/insert db "tweet" tweet)))
