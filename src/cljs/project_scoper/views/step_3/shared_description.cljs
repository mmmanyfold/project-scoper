(ns project-scoper.views.step-3.shared-description
  (:require [re-frame.core :as rf]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn description-view []
  [:div
   [:h2 "Please describe:"]
   [:textarea {:rows 7}]
   [controls true true]])