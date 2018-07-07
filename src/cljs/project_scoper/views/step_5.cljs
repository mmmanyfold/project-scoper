(ns project-scoper.views.step-5
  (:require [re-frame.core :as rf]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]))

(defn step-5-view []
  [:div
   [:h2 "Additional comments?"]
   [:textarea {:rows 7}]
   [controls true true]])