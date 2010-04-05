(ns am.ik.clj-gae-users.core
  (:use [clojure.contrib.singleton])
  (:import [com.google.appengine.api.users User UserService UserServiceFactory FederatedLoginUser]))

(def 
 #^{:arglists '([])
    :doc "get UserService. This method returns singleton instance of the service."} 
 #^UserService
 get-user-service (global-singleton #(UserServiceFactory/getUserService)))

(defn #^User get-current-user 
  "If the user is logged in, returns com.google.appengine.api.users.User object."
  []
  (.getCurrentUser (get-user-service)))

(defn get-current-user-map
  []
  (let [user (get-current-user)]
    (if user
      {:auth-domain (.getAuthDomain user), :email (.getEmail user),
       :nickname (.getNickname user), :userId (.getUserId user)})))

(defn #^FederatedLoginUser get-current-federated-user
  "If the user is logged in, returns com.google.appengine.api.users.FederatedLoginUser object."
  []
  (.getCurrentFederatedUser (get-user-service)))

(defn #^String create-login-url 
  "Returns String of login URL page to the user."
  ([dest-url]
     (.createLoginURL (get-user-service) dest-url))
  ([dest-url auth-domain]
     (.createLoginURL (get-user-service) dest-url auth-domain)))

(defn #^String create-logout-url 
  "Returns String of logout URL page to the userr."
  ([dest-url]
     (.createLogoutURL (get-user-service) dest-url))
  ([dest-url auth-domain]
     (.createLogoutURL (get-user-service) dest-url auth-domain)))

;; (defn #^String create-federated-login-url 
;;   [federated-identity dest-url authority attributes-request]
;;   (.createFederatedLoginURL (get-user-service) federated-identity dest-url authority attributes-request))

;; (defn #^String create-federated-logout-url 
;;   [dest-url]
;;   (.createFederatedLogoutURL (get-user-service) dest-url))

(defn user-admin? []
  "Retuns true if a user is admin, otherwise false."
  []
  (.isUserAdmin (get-user-service)))

(defn user-logged-in? []
  "Retuns true if a user is logged in, otherwise false."
  []
  (.isUserLoggedIn (get-user-service)))