(ns project-scoper.components.bubble
  (:require [re-frame.core :as rf]
            [project-scoper.events :as events]
            [project-scoper.helpers :refer [keywordize-name]]))

(def colors {:red "#EB5757"
             :green "#6FCF97"
             :blue "#56CCF2"
             :purple "#BB6BD9"
             :yellow "#F2C94C"})

(defn bubble [color-key text sub db-key value]
  (let [color-val (color-key colors)
        selected? (= @(rf/subscribe [(keyword (str "project-scoper.subs/" (name sub)))]) value)] ;construct full subscription from sub name
    [:div.bubble {:style {:border-color color-val
                          :background-color (if selected?
                                              color-val
                                              "white")
                          :color (if selected?
                                   "white"
                                   color-val)}
                  :on-click #(rf/dispatch [::events/set-value db-key value])}
      [:div.text text]]))
