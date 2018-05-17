(ns project-scoper.app
  (:require [re-frame.core :as rf]
            [re-com.core :as re-com]
            [project-scoper.subs :as subs]
            [project-scoper.views.start :refer [start-view]]
            [project-scoper.views.select-type :refer [select-type]]
            [project-scoper.views.web-select.primary :refer [web-select-primary]]))

(defn- views [view-name]
       (case view-name
             :start-view [start-view]
             :select-type [select-type]
             :web-select-primary [web-select-primary]
             [:div]))

(defn app-view []
  (let [active-view @(rf/subscribe [::subs/active-view])]
    [:div
     [:div.nav
      [:div
        [:span [:a {:href "http://mmmanyfold.com" :target "_blank"} "brought to you by mmmanyfold"]]]]
     [:header
      [:div.img-wrapper
       [:a.logo {:href "/"}
        [:img {:src "img/logo-graydient-invert.png"}]]]
      [:h1 "project scoper"]
      [:p.subtitle "define your digital needs"]]
     [:div.view-container
      [views active-view]]]))
