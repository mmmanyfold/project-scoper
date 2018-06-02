(ns project-scoper.views.web-select.primary
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn web-select-primary []
  [:div
   [:h2 "primary purpose:"]
   [:div.bubbles-wrap
    [bubble :green "portfolio / gallery" :primary]
    [bubble :blue "sell online" :primary]
    [bubble :purple "blogging" :primary]
    [bubble :yellow "share business info" :primary]
    [bubble :red "other" :primary]]
   (let [primary @(rf/subscribe [::subs/primary])]
     (if-not (nil? primary)
       [controls true (name primary)]
       [controls true nil]))])
