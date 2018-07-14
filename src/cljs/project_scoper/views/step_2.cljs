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
        [bubble :green "website" :type [:project-scope :step-2] :website]
        [bubble :blue "mobile app" :type [:project-scope :step-2] :mobile-app]
        [bubble :purple "service or integration" :type [:project-scope :step-2] :service-integration]
        [bubble :yellow "interactive installation" :type [:project-scope :step-2] :installation]
        [bubble :red "not sure" :type [:project-scope :step-2] :not-sure]]
       (let [type @(rf/subscribe [::subs/type])]
         (if-not (nil? type)
           [controls "" (name type)]
           [controls true nil]))])
