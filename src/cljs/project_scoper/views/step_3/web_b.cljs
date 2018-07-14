(ns project-scoper.views.step-3.web-b
  (:require [re-frame.core :as rf]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.helpers :refer [unkeywordize]]
            [secretary.core :as secretary]))

(def all-options #{:blogging :gallery-portfolio :sell-online :business-website})

(defn web-b-view []
  (if-let [primary-key @(rf/subscribe [::subs/primary])]
    (let [options (remove #{primary-key} all-options)
          current-options @(rf/subscribe [::subs/secondary])]
      [:div
       [:h2 "secondary function(s):"]
       [:form
        [:h5 [:i "> check all that apply"]]
        (for [opt options]
          ^{:key (gensym "opt-")}
          [:div
           [:input {:type    "checkbox"
                    :checked (contains? current-options opt)
                    :on-change
                             (fn [e]
                               (let [path [:project-scope :step-3 :website :secondary]]
                                 (if (-> e .-target .-checked)
                                   (rf/dispatch
                                     [::events/set-value path (conj current-options opt)])
                                   (rf/dispatch
                                     [::events/set-value path (disj current-options opt)]))))}]
           [:label
            (cond
              (= :gallery-portfolio opt) "gallery / portfolio"
              :else (unkeywordize opt))]])]
       [controls true true "/#/step/3/website/c"]])
    (secretary/dispatch! "/")))

