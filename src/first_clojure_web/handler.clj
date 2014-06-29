(ns first-clojure-web.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [first-clojure-web.tweet-service :as tweet-service]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.middleware.json :refer [wrap-json-response]]
            [liberator.core :refer [resource defresource]]))

(defroutes app-routes
  (GET "/" [] (resource :available-media-types ["text/html"]
                        :handle-ok "<html>Hello, Internet.</html>"))

  (context "/api/tweet" []
           (GET "/" [] (resource :available-media-types ["application/json"]
                                 :handle-ok (tweet-service/get-tweets)))
           (POST "/save" {body :body} (resource :available-media-types ["application/json"]
                                                :allowed-methods [:post]
                                                :allowed? (fn [request]  
                                                            (if (= (count body) 1) (contains? body "tweet") false))
                                                :post! (fn [request] (tweet-service/save-tweet (clojure.walk/keywordize-keys body)))
                                                :handle-created (fn [_] "Created")))))
(def app
  (-> app-routes
      (wrap-params) (wrap-json-body) (wrap-json-response)))
