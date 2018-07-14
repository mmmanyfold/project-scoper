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
  ::contact-name
  (fn [db _]
    (:contact-name db)))

(re-frame/reg-sub
  ::contact-email
  (fn [db _]
    (:contact-email db)))

(re-frame/reg-sub
  ::platform
  (fn [db _]
   (:platform db)))

(re-frame/reg-sub
  ::user-accounts?
  (fn [db _]
    (get-in db [:step-3 :website :user-accounts?])))

(re-frame/reg-sub
  ::design-provided?
  (fn [db _]
    (get-in db [:step-3 :website :design-provided?])))

(re-frame/reg-sub
  ::design-provided
  (fn [db _]
    (get-in db [:step-3 :website :design-provided])))

;TODO add logic to change :website to either mobile-app or website based on path

(re-frame/reg-sub
  ::deadline-type
  (fn [db _]
    (get-in db [:step-4 :deadline-type])))
