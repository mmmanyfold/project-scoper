(ns project-scoper.views.step-4
  (:require [cljsjs.pikaday]
            [cljsjs.moment]
            [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]))

(defn step-4-view []
  (reagent/create-class
    {:component-did-mount
     (fn []
       (let [start-picker (js/Pikaday. #js {:field    (js/document.getElementById "start-datepicker")
                                            :format   "D MMM YYYY"
                                            :minDate (js/Date.)
                                            :defaultDate (js/Date.)
                                            :setDefaultDate true})
             end-picker (js/Pikaday. #js {:field    (js/document.getElementById "end-datepicker")
                                          :format   "D MMM YYYY"
                                          :minDate (js/Date.)})]))
     :reagent-render
     (fn []
       [:div
        [:h2 "Proposed start date:"]
        [:input#start-datepicker {:type "text"}]
        [:h2 "Deadline"]
        [:input#end-datepicker {:type "text"}]
        [:div.bubbles-wrap
         [bubble :green "hard deadline" :deadline-type]
         [bubble :blue "soft deadline" :deadline-type]]])}))

