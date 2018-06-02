(ns project-scoper.views.web-select.secondary
  (:require [reagent.core :as rg]))

(def options ["blog", "portfolio", "online shop", "business info"])

(defn web-select-secondary []
  [:div
   [:h2 "secondary function(s):"]
   [:h5 "check all that apply"]
   [:form.web-select-secondary
    (doall (for [opt options
                 :let [checked? (rg/atom false)]]
             ^{:key (gensym "opt-")}
              [:div
               [:input {:type "checkbox"
                        :on-click #(swap! checked? not)}]
               [:label opt]]))]])
