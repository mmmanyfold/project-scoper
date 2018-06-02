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
    [bubble :green "start from scratch" :path]
    [bubble :blue "build on an existing project" :path]]
   (let [path @(rf/subscribe [::subs/path])]
     (if-not (nil? path)
       [controls false (name path)]))])
