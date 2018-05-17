(ns project-scoper.components.bubble
  (:require [re-frame.core :as rf]))

(def colors {:red "#EB5757"
             :green "#6FCF97"
             :blue "#56CCF2"
             :purple "#BB6BD9"
             :yellow "#F2C94C"})

(defn bubble [color-key text & [event]]
  (let [color-val (some #(when (= color-key (first %)) (second %)) colors)]
    ; TODO: add selection functionality
    [:div.bubble {:style {:border-color color-val
                          :color color-val}
                  :on-click #(rf/dispatch event)}
      [:div.text text]]))
