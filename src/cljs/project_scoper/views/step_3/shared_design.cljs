(ns project-scoper.views.step-3.shared-design
  (:require [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]))

(defn design-view []
  (let [type @(rf/subscribe [::subs/type])]
    [:div
     [:h2 "Will you provide the design/visual identity?"]
     [:div.bubbles-wrap
      [bubble :green "Yes" :design-provided? [:project-scope :step-3 type :design-provided?] true]
      [bubble :blue "No" :design-provided? [:project-scope :step-3 type :design-provided?] false]]
     (let [design-provided? @(rf/subscribe [::subs/design-provided?])
           design-provided @(rf/subscribe [::subs/design-provided])
           design-options ["Logo" "Colors" "Fonts" "Icons" "Images" "Site map" "Mockups"]]
       (if design-provided?
         [:form.web-select-secondary
          [:h3 "What will you provide?"]
          [:h5 [:i "> check all that apply"]]
          (doall (for [opt design-options
                       :let [checked? (reagent/atom false)]]
                   ^{:key (gensym "opt-")}
                   [:div
                    [:input {:type "checkbox"
                             :on-click #(swap! checked? not)}]
                    [:label opt]]))
          (when-not (nil? design-provided)
            [controls true true])]
         [controls true true]))]))
