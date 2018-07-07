(ns project-scoper.views.step-2
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn step-2-view []
      [:div
       (let [path @(rf/subscribe [::subs/path])]
         (if (= path :start-from-scratch)
           [:h2 "type of project:"]
           [:h2 "what type of thing is it?"]))
       [:div.bubbles-wrap
        [bubble :green "website" :type]
        [bubble :blue "mobile app" :type]
        [bubble :purple "service or integration" :type]
        [bubble :yellow "interactive installation" :type]
        [bubble :red "not sure" :type]]
       (let [type @(rf/subscribe [::subs/type])]
         (if-not (nil? type)
           [controls "" (name type)]
           [controls true nil]))])
