(ns project-scoper.views.step-4
  (:require [cljsjs.pikaday]
            [cljsjs.moment]
            [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.subs :as subs]
            [project-scoper.events :as events]))

(defn set-date [date-key value]
  (rf/dispatch [::events/set-value [:project-scope :step-4 date-key] value]))

(defn step-4-view []
  (reagent/create-class
    {:component-did-mount
     (fn []
       (let [start-picker (js/Pikaday. #js {:field    (js/document.getElementById "start-datepicker")
                                            :format   "D MMM YYYY"
                                            :minDate (js/Date.)
                                            :defaultDate (js/Date.)
                                            :setDefaultDate true
                                            :onSelect #(set-date :start-date %)})
             end-picker (js/Pikaday. #js {:field    (js/document.getElementById "end-datepicker")
                                          :format   "D MMM YYYY"
                                          :minDate (js/Date.)
                                          :onSelect #(set-date :deadline %)})]
         (set-date :start-date (.getDate start-picker))))
     :reagent-render
     (fn []
        (let [deadline-type @(rf/subscribe [::subs/deadline-type])
              date-picked? (and (not (nil? @(rf/subscribe [::subs/deadline])))
                                (not (nil? @(rf/subscribe [::subs/start-date]))))]
          [:div
           [:h2 "Proposed start date:"]
           [:input#start-datepicker {:type "text"}]
           [:h2 "Deadline"]
           [:input#end-datepicker {:type "text"}]
           [:div.bubbles-wrap
            [bubble :green "hard deadline" :deadline-type [:project-scope :step-4 :deadline-type] :hard]
            [bubble :blue "soft deadline" :deadline-type [:project-scope :step-4 :deadline-type] :soft]]
           (when (and date-picked?
                      (not (nil? deadline-type)))
             [controls true true])]))}))

