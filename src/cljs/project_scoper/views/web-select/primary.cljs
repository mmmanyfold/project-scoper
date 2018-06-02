(ns project-scoper.views.web-select.primary
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]))

(defn web-select-primary []
  [:div
   [:h2 "primary purpose:"]
   [:div.bubbles-wrap
    ; TODO: store current selection
    [bubble :green "portfolio / gallery" :primary]
    [bubble :blue "sell online" :primary]
    [bubble :purple "blogging" :primary]
    [bubble :yellow "share business info" :primary]
    [bubble :red "other" :primary]]
   [controls "type"]])
