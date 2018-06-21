(ns project-scoper.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::active-view
 (fn [db _]
   (:active-view db)))

(re-frame/reg-sub
  ::current-path
  (fn [db _]
    (:current-path db)))

(re-frame/reg-sub
  ::path
  (fn [db _]
    (:path db)))

(re-frame/reg-sub
  ::type
  (fn [db _]
    (:type db)))

(re-frame/reg-sub
  ::primary
  (fn [db _]
    (:primary db)))

(re-frame/reg-sub
  ::secondary
  (fn [db _]
    (:secondary db)))

(re-frame/reg-sub
  ::platform?
  (fn [db _]
    (:platform? db)))

(re-frame/reg-sub
  ::platform-name
  (fn [db _]
    (:platform-name db)))
  
(re-frame/reg-sub
  ::platform
  (fn [db _]
   (:platform db)))