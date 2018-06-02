(ns project-scoper.views.select-type
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]))

(defn select-type []
  [:div
   [:h2 "type of project:"]
   [:div.bubbles-wrap
    ; TODO: pass slug to controls component
    ; based on current selection
    [bubble :green "website" :type]
    [bubble :blue "mobile app" :type]
    [bubble :purple "service or integration" :type]
    [bubble :yellow "interactive installation" :type]
    [bubble :red "not sure" :type]]
   [controls "" "web/primary"]])
