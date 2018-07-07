(ns project-scoper.views.step-3.shared-integrations
  (:require [reagent.core :as reagent]
            [re-frame.core :as rf]
            [project-scoper.subs :as subs]
            [project-scoper.components.short-text :refer [short-text]]
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.helpers :refer [unkeywordize]]))

(defn integrations-view [type]
  (let [options ["youtube/vimeo", "google app(s)", "social media"]
        other? (reagent/atom false)]
    (fn []
      [:div
       ;;TODO: pass in type (website or mobile app)
       [:h2 (str "Does your " type "need to integrate with any other platforms?")]
       [:form.web-select-secondary
        [:h5 [:i "> check all that apply"]]
        (doall (for [opt options
                     :let [checked? (reagent/atom false)]]
                 ^{:key (gensym "opt-")}
                  [:div
                   [:input {:type "checkbox"
                            :on-click #(swap! checked? not)}]
                   [:label opt]]))
        [:div
         [:input {:type "checkbox"
                  :on-click #(swap! other? not)}]
         [:label "other"]
         (when @other? [short-text "" :integrations])]]
       ;TODO: store selections in vector, figure out next route
       [controls true true]])))