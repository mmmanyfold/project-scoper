(ns project-scoper.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::active-view
 (fn [db _]
   (:active-view db)))
