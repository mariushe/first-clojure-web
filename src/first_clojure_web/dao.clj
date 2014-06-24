(ns first-clojure-web.dao
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

;; localhost, default port
(defn insertData [data]
  (let [conn (mg/connect)
        db   (mg/get-db conn "monger-test")]
    (mc/insert db "test" {:name "John"})))
