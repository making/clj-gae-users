(defproject am.ik/clj-gae-users "0.1.0-SNAPSHOT"
  :description "a UserService library on Google App Engine for Clojure"
  :repositories {"gaejtools" "http://gaejtools.sourceforge.jp/maven/repository"}
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]
                 [com.google.appengine/appengine-api-1.0-sdk "1.3.2"]]
  :dev-dependencies [[am.ik/clj-gae-testing "0.1.0"]
                     ;; [leiningen/lein-swank "1.1.0"]
                     [lein-clojars "0.5.0-SNAPSHOT"]
                     ] 
  :namespaces [am.ik.clj-gae-users.core])