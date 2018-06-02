(ns project-scoper.events
  (:require [re-frame.core :as re-frame]
            [project-scoper.db :as db]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-view
 (fn [db [_ active-view]]
   (assoc db :active-view active-view)))

(re-frame/reg-event-db
  ::set-value
  (fn [db [_ db-key value]]
    (assoc db db-key value)))
