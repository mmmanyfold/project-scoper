(ns project-scoper.views.web-select.platform
  (:require [re-frame.core :as rf]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.short-text :refer [short-text]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]
            [project-scoper.events :as events]))

(defn web-select-platform []
  [:div
   (let [path @(rf/subscribe [::subs/path])]
     (if (= path :start-from-scratch)
       [:h2 "do you have a platform in mind?"]
       [:h2 "are you using a specific platform?"]))
   [:div.bubbles-wrap
    [bubble :green "yes" :platform?]
    [bubble :blue "no" :platform?]]
   (let [platform? @(rf/subscribe [::subs/platform?])]
       (if-not (nil? platform?)
         (if (= platform? :yes)
           [:div
            [short-text "platform name" :platform-name]
            (let [platform-name @(rf/subscribe [::subs/platform-name])]
              (if-not (nil? platform-name)
                [controls true (name platform?)]
                [controls true nil]))]
           [:div
             (rf/dispatch [::events/set-value :platform-name nil])
             [controls true (name platform?)]])
         [controls true nil]))])
