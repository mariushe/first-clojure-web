(ns first-clojure-web.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" {params :params} (str "Hello World " (get params :name) "!"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
