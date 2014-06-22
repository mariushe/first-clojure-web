(ns first-clojure-web.test.provider
  (:use clojure.test
        first-clojure-web.provider))

(deftest test-app
  (testing "hello world"
      (is (= (helloworld {:name "my name"}) "{\"user\":\"my name\"}"))))
