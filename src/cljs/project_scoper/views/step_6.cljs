(ns project-scoper.views.step-6
  (:require [re-frame.core :as rf]
            [project-scoper.components.short-text :refer [short-text]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]
            [project-scoper.events :as events]))

(defn step-6-view []
  [:div
   [:h2 "Contact"]
   [:h3
    [short-text "Name" :contact-name]]
   [:h3
    [short-text "Email address" :contact-email]]
   [:button.pv2.ph3.mt4
    "PREVIEW PDF"]])
