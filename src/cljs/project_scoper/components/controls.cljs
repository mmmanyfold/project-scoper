(ns project-scoper.components.controls
  (:require [re-frame.core :as rf]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]))

(defn controls [back? selection]
  [:div.controls
   (when back?
     [:span {:on-click #(rf/dispatch [::events/navigate-back])}
      [:h3 [:i {:class "zmdi zmdi-caret-left"}] " back"]])
   (when selection
     [:span {:on-click #(rf/dispatch [::events/navigate-forward selection])}
      [:h3 "next " [:i {:class "zmdi zmdi-caret-right"}]]])])
