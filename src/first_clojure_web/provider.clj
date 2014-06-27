(ns first-clojure-web.provider
  (:use first-clojure-web.tweet-dao)
  (:require [clojure.data.json :as json]))

(def tweet (fn[id] (json/write-str (get-tweet id))))
