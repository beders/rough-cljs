(defproject monoid/rough-cljs "1.0.0"
  :dependencies [[thheller/shadow-cljs "2.8.94"]
                 [binaryage/devtools "1.0.0"]
                 [reagent "0.10.0"]
                 [org.clojure/spec.alpha "0.2.187"]
                 ]
  :license {:name "MIT License"}
  :repositories
  {"clojars" {:url "https://clojars.org/repo"
              :sign-releases false}}
  :plugins []
  :source-paths ["src/main"]
  :test-paths ["src/test"]
  :jar-exclusions [#"example\.cljs"]
  :profiles {
             :dev {:dependencies [[org.clojure/test.check "1.0.0"]]}
             :test {:dependencies [[org.clojure/test.check "1.0.0"]]}}
  )
