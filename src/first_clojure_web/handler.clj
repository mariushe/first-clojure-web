(ns first-clojure-web.handler
  (:use compojure.core
        first-clojure-web.provider)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.params :refer [wrap-params]]
            [liberator.core :refer [resource defresource]]))

(defroutes app-routes
           (GET "/" {params :query-params} (resource :available-media-types ["application/json"]
                                    :handle-ok (helloworld {:name (params "name")}))))
(def app
  (-> app-routes
      (wrap-params)))
