(ns project-scoper.views.web-select.primary
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]))

(defn web-select-primary []
  [:div
   [:h2 "primary purpose:"]
   [:div.bubbles-wrap
    ; TODO: store current selection
    [bubble :green "portfolio / gallery"]
    [bubble :blue "sell online"]
    [bubble :purple "blogging"]
    [bubble :yellow "share business info"]
    [bubble :red "other"]]
   [controls "type"]])
