(ns project-scoper.events
  (:require [re-frame.core :as re-frame]
            [project-scoper.db :as db]
            [clojure.string :refer [split join]]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-view
 (fn [db [_ active-view & [params]]]
   (assoc db :active-view active-view)))

(re-frame/reg-event-db
  ::set-value
  (fn [db [_ db-key value]]
    (assoc-in db db-key value)))

(re-frame/reg-event-db
  ::navigate-back
  (fn [db [_]]
    (let [path-arr (split (:current-path db) "/")
          count (count path-arr)
          path (str (join "/" (take (- count 1) path-arr)) "/")]
      (prn path)
      (set! (.-hash (.-location js/window)) path)
      (assoc db :current-path path))))

(re-frame/reg-event-db
  ::navigate-forward
  (fn [db [_ selection]]
    (let [path (str (:current-path db) selection "/")]
      (set! (.-hash (.-location js/window)) path)
      (assoc db :current-path path))))
