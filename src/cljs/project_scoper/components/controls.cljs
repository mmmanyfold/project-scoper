(ns project-scoper.components.controls
  (:require [re-frame.core :as rf]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]))

(def colors {:red "#EB5757"
             :green "#6FCF97"
             :blue "#56CCF2"
             :purple "#BB6BD9"
             :yellow "#F2C94C"})

(defn controls [back? selection]
  [:div.controls
   (when back?
     [:span {:on-click #(rf/dispatch [::events/navigate-back])}
      [:h3 [:i {:class "zmdi zmdi-caret-left"}] " back"]])
   (when selection
     [:span {:on-click #(rf/dispatch [::events/navigate-forward selection])}
      [:h3 "next " [:i {:class "zmdi zmdi-caret-right"}]]])])
