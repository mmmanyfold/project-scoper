(ns project-scoper.views.step-5
  (:require [re-frame.core :as rf]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]
            [reagent.core :as reagent]))

(defn step-5-view []
  (let [chars (reagent/atom 280)]
    (fn []
      [:div
       [:h2 "Additional comments?"]
       [:textarea
        {:rows 7
         :maxLength 280
         :on-change (fn [e] (reset! chars (- 280 (count (-> e .-target .-value)))))}]
       [:p [:span @chars] " characters remaining"]
       [controls true true]])))