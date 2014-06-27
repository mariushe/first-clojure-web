(ns first-clojure-web.handler
  (:use compojure.core
        first-clojure-web.provider)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-body]]
            [liberator.core :refer [resource defresource]]))

(defroutes app-routes
           (GET "/api/tweet/:id" [id] (resource :available-media-types ["application/json"]
                                    :handle-ok (tweet id))))
(def app
  (-> app-routes
      (wrap-params) (wrap-json-body)))
