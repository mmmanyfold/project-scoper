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
       (let [type @(rf/subscribe [::subs/type])
             _ (js/console.log type)]
         (case type
           :website [controls true (name type) "/#/step/3/website/a"]
           :mobile-app [controls true (name type) "/#/step/3/mobile-app/a"]
           :service-or-integration [controls true (name type) "/#/step/3/service"]
           :interactive-installation [controls true (name type) "/#/step/3/installation"]
           :not-sure [controls true (name type) "/#/step/3/not-sure"]
           nil [controls true false]))])
