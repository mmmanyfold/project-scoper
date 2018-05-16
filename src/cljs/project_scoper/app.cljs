(ns project-scoper.app
  (:require [re-frame.core :as rf]
            [re-com.core :as re-com]
            [project-scoper.subs :as subs]
            [project-scoper.views.start :refer [start-view]]))

(defn- views [view-name]
       (case view-name
             :start-view [start-view]
             [:div]))

(defn app-view []
  [:div
   [:div.nav
    [:div
      [:span [:a {:href "http://mmmanyfold.com" :target "_blank"} "brought to you by mmmanyfold"]]]]
   [:header
    [:div.img-wrapper
     [:a.logo {:href "/"}
      [:img {:src "img/logo-graydient-invert.png"}]]]
    [:h1 "project scoper"]
    [:p.subtitle "for all your digital needs"]]
   [:div.view-container
    [views @(rf/subscribe [::subs/active-view])]]])
