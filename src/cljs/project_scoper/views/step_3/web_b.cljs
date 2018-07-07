(ns project-scoper.views.web-select.web-b
  (:require [reagent.core :as reagent]
            [re-frame.core :as rf]
            [project-scoper.subs :as subs]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.helpers :refer [unkeywordize]]))

(def all-options ["blogging", "gallery / portfolio", "sell online", "share business info"])

(defn web-b-view []
      (let [primary-key @(rf/subscribe [::subs/primary])
            primary-string (unkeywordize primary-key)
            options (remove #{primary-string} all-options)]
        [:div
         [:h2 "secondary function(s):"]
         [:form.web-select-secondary
          [:h5 [:i "> check all that apply"]]
          (doall (for [opt options
                       :let [checked? (reagent/atom false)]]
                   ^{:key (gensym "opt-")}
                    [:div
                     [:input {:type "checkbox"
                              :on-click #(swap! checked? not)}]
                     [:label opt]]))]
         ;TODO: store selections in vector, figure out next route
         (let [secondary @(rf/subscribe [::subs/secondary])]
           (if-not (nil? secondary)
             [controls true (name secondary)]
             [controls true nil]))]))
