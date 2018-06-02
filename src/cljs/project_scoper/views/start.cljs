(ns project-scoper.views.start
  (:require [re-frame.core :as rf]
            [project-scoper.events :as events]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.subs :as subs]))

(defn start-view []
  [:div
   [:h2 "I need to..."]
   [:div.bubbles-wrap
    ; TODO: store current selection
    [bubble :green "start from scratch" :path :from-scratch]
    [bubble :blue "build on an existing project" :path :build-on]]
   [controls nil "type"]])
