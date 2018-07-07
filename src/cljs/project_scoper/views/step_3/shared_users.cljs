(ns project-scoper.views.step-3.shared-users
  (:require [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn users-view []
  [:div
   [:h2 "Do you need user accounts?"]
   [:div.bubbles-wrap
    [bubble :green "yes" :users]
    [bubble :blue "no" :users]]
   (let [users @(rf/subscribe [::subs/users])]
     (when-not (nil? users)
       [controls true true]))])
