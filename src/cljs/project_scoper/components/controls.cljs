(ns project-scoper.components.controls)

(defn controls [back? selection next]
  [:div.controls
   (when back?
     [:a {:on-click #(.back (.-history js/window))}
      [:h3 [:i {:class "zmdi zmdi-caret-left"}] " back"]])
   (when selection
     [:a {:href next}
      [:h3 "next " [:i {:class "zmdi zmdi-caret-right"}]]])])
