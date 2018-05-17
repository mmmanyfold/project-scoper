(ns project-scoper.views.start
  (:require [re-frame.core :as rf]
            [project-scoper.events :as events]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.components.bubble :refer [bubble]]))

(defn start-view []
  [:div
   [:h2 "I need to..."]
   [:div.bubbles-wrap
    ; TODO: store current selection
    [bubble :green "start from scratch"]
    [bubble :blue "build on an existing project"]]
   [controls nil "type"]])
