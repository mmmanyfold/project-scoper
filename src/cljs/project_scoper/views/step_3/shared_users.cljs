(ns project-scoper.views.step-3.shared-users
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn users-view []
  (let [type @(rf/subscribe [::subs/type])]
    [:div
     [:h2 "Do you need user accounts?"]
     [:div.bubbles-wrap
      [bubble :green "yes" :user-accounts? [:project-scope :step-3 type :user-accounts?] true]
      [bubble :blue "no" :user-accounts? [:project-scope :step-3 type :user-accounts?] false]]
     (let [users @(rf/subscribe [::subs/user-accounts?])]
       (when-not (nil? users)
         [controls true true]))]))
