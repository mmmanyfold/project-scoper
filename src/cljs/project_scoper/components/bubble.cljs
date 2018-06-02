(ns project-scoper.components.bubble
  (:require [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]))

(def colors {:red "#EB5757"
             :green "#6FCF97"
             :blue "#56CCF2"
             :purple "#BB6BD9"
             :yellow "#F2C94C"})

(defn bubble [color-key text db-key db-value]
  (let [color-val (color-key colors)]
    (fn []
      (let [selected? (= @(rf/subscribe [(keyword (str "project-scoper.subs/" (name db-key)))]) db-value)]
       [:div.bubble {:style {:border-color color-val
                             :background-color (if selected?
                                                 color-val
                                                 "white")
                             :color (if selected?
                                      "white"
                                      color-val)}
                     :on-click #(rf/dispatch [::events/set-value db-key db-value])}
         [:div.text text]]))))
