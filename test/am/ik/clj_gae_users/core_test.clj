(ns am.ik.clj-gae-users.core-test
  (:use [am.ik.clj-gae-users.core] :reload-all)
  (:use [am.ik.clj-gae-testing.test-utils])
  (:use [clojure.test]))

(defdstest test-get-user-service01
  (is (= (get-user-service) (get-user-service))))

(defdstest test-get-user-service02
  (is `(not ~(apply = (pmap (fn [_] (get-user-service)) (range 2))))))

(defdstest test-create-login-url
  (is (not-empty (create-login-url "/")))
  (is (not-empty (create-login-url "/" "aa"))))

(defdstest test-create-logout-url
  (is (not-empty (create-logout-url "/")))
  (is (not-empty (create-logout-url "/" "aa"))))

(defdstest test-logged-in?
  (is (not (user-logged-in?))))
