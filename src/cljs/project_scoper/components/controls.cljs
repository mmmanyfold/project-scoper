(ns project-scoper.components.controls
  (:require [re-frame.core :as rf]))

(def colors {:red "#EB5757"
             :green "#6FCF97"
             :blue "#56CCF2"
             :purple "#BB6BD9"
             :yellow "#F2C94C"})

(defn controls [back-slug next-slug]
  [:div.controls
   (when back-slug
     [:a {:href (str "/#/" back-slug)}
      [:h3 [:i {:class "zmdi zmdi-caret-left"}] " back"]])
   (when next-slug
     [:a {:href (str "/#/" next-slug)}
      [:h3 "next " [:i {:class "zmdi zmdi-caret-right"}]]])])
