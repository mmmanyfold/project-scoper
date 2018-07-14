(ns project-scoper.views.step-3.web-a
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn web-a-view []
  [:div
   [:h2 "primary purpose:"]
   [:div.bubbles-wrap
    [bubble :green "gallery / portfolio" :primary [:project-scope :step-3 :website :primary] :gallery-portfolio]
    [bubble :blue "sell online" :primary [:project-scope :step-3 :website :primary] :sell-online]
    [bubble :purple "blogging" :primary [:project-scope :step-3 :website :primary] :blogging]
    [bubble :yellow "business website" :primary [:project-scope :step-3 :website :primary] :business-website]
    [bubble :red "other" :primary [:project-scope :step-3 :website :primary] :other]]
   (let [primary @(rf/subscribe [::subs/primary])]
     (if-not (nil? primary)
       [controls true (name primary)]
       [controls true nil]))])
