(ns first-clojure-web.handler
  (:use compojure.core
        first-clojure-web.provider)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" {params :params} (helloworld (get params :name)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))


