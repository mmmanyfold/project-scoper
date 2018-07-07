(ns project-scoper.views.step-3.mobile-a
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn mobile-a-view []
  [:div
    [:h2 "Platform:"]
    [:div.bubbles-wrap
      [bubble :green "iOS" :platform]
      [bubble :purple "Android" :platform]
      [bubble :blue "iOS & Android" :platform]
      [bubble :yellow "Don't Care" :platform]
      (let [platform @(rf/subscribe [::subs/platform])]
        (if-not (nil? platform)
          [controls true (name platform)]
          [controls true nil]))]])
