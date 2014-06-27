(ns first-clojure-web.tweet-dao
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

;; localhost, default port
(defn get-tweet [data]
  (let [conn (mg/connect)
        db   (mg/get-db conn "mytweet")]
    (mc/insert db "tweet" {:name "John"})))
