(ns project-scoper.views.step-3.web-c
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.short-text :refer [short-text]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]
            [project-scoper.events :as events]))

(defn web-c-view []
      [:div
       (let [path @(rf/subscribe [::subs/path])]
         (if (= path :start-from-scratch)
           [:h2 "do you have a platform in mind?"]
           [:h2 "are you using a specific platform?"]))
       [:div.bubbles-wrap
        [bubble :green "yes" :platform? [:project-scope :step-3 :website :platform?] true]
        [bubble :blue "no" :platform? [:project-scope :step-3 :website :platform?] false]]
       (let [platform? @(rf/subscribe [::subs/platform?])]
           (if-not (nil? platform?)
             (if (= platform? true)
               [:div
                [short-text "platform name" [:project-scope :step-3 :website :platform-name]]
                (let [platform-name @(rf/subscribe [::subs/platform-name])]
                  (if-not (nil? platform-name)
                    [controls true true]
                    [controls true nil]))]
               [:div
                 (rf/dispatch [::events/set-value [:project-scope :step-3 :website :platform-name] nil])
                 [controls true true]])
             [controls true nil]))])
