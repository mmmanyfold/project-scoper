(ns project-scoper.components.short-text
  (:require [re-frame.core :as rf]
            [reagent.core :as reagent]
            [project-scoper.events :as events]
            [project-scoper.subs :as subs]
            [project-scoper.helpers :refer [keywordize-name]]
            [clojure.string :refer [blank?]]))

(defn short-text [placeholder db-key]
  [:input.short-text {:type "text"
                      :placeholder placeholder
                      :on-change (fn [e]
                                   (let [value (.-value (.-target e))]
                                     (if-not (blank? value)
                                       (rf/dispatch [::events/set-value db-key value])
                                       (rf/dispatch [::events/set-value db-key nil]))))}])
