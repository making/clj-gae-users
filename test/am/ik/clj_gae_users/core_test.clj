(ns am.ik.clj-gae-users.core-test
  (:use [am.ik.clj-gae-users.core] :reload-all)
  (:use [am.ik.clj-gae-testing.test-utils])
  (:use [clojure.test]))

(defdstest test-create-login-url
  (is (not-empty (create-login-url "/")))
  (is (not-empty (create-login-url "/" "aa"))))

(defdstest test-create-logout-url
  (is (not-empty (create-logout-url "/")))
  (is (not-empty (create-logout-url "/" "aa"))))

(defdstest test-logged-in?
  (is (not (user-logged-in?))))