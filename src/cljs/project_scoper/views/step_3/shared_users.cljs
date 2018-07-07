(ns project-scoper.views.step-3.shared-users
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn users-view []
  [:div
   [:h2 "Do you need user accounts?"]
   [:div.bubbles-wrap
    [bubble :green "yes" :user-accounts?]
    [bubble :blue "no" :user-accounts?]]
   (let [users @(rf/subscribe [::subs/user-accounts?])]
     (when-not (nil? users)
       [controls true true]))])
