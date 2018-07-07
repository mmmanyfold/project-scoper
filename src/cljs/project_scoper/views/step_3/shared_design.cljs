(ns project-scoper.views.step-3.shared-design
  (:require [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.components.bubble :refer [bubble]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]))

(def design-options ["Logo" "Colors" "Fonts" "Icons" "Images" "Site map" "Mockups"])

(defn design-view []
  (fn []
    [:div
     [:h2 "Will you provide the design/visual identity?"]
     [:div.bubbles-wrap
      [bubble :green "Yes" :design-provided?]
      [bubble :blue "No" :design-provided?]]
     (let [design-provided? @(rf/subscribe [::subs/design-provided?])
           design-provided @(rf/subscribe [::subs/design-provided])]
       (if design-provided?
         [:form.design-options
          [:h3 "What will you provide?"]
          [:h4 "Check all that apply"]
          (doall (for [opt design-options]
                   ^{:key (gensym "opt-")}
                   [:div
                    [:input {:type "checkbox"}]
                    [:label opt]]))
          (when-not (nil? design-provided)
            [controls true true])]
         [controls true true]))]))
