(ns first-clojure-web.provider
  (:require [clojure.data.json :as json]))

(def helloworld (fn[params] (json/write-str {:user (-> params :name)})))

(def custom-add (fn[first, second] (+ first second)))
