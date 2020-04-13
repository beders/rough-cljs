(ns rough-test
  (:require [cljs.test :refer [deftest testing is]]
            [clojure.spec.alpha :as s]
            [rough-cljs.spec]
            [example]
            ))

(deftest spec
  (is (s/valid? :rough/rectangle [:rectangle [0 0 0 0]]))
  )

(deftest examples
  (testing "If logo data conforms to specs"
           (is (s/valid? :rough/primitives example/logo)))
  )
