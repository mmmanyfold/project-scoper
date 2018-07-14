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
    (get-in db [:project-scope :step-1])))

(re-frame/reg-sub
  ::type
  (fn [db _]
    (get-in db [:project-scope :step-2])))

(re-frame/reg-sub
  ::primary
  (fn [db _]
    (get-in db [:project-scope :step-3 :website :primary])))

(re-frame/reg-sub
  ::secondary
  (fn [db _]
    (:secondary db)))

(re-frame/reg-sub
  ::platform?
  (fn [db _]
    (get-in db [:project-scope :step-3 :website :platform?])))

(re-frame/reg-sub
  ::platform-name
  (fn [db _]
    (get-in db [:project-scope :step-3 :website :platform-name])))

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
   (get-in db [:project-scope :step-3 :mobile-app :platform])))

(re-frame/reg-sub
  ::user-accounts?
  (fn [db _]
    (let [type (get-in db [:project-scope :step-2])]
      (get-in db [:project-scope :step-3 type :user-accounts?]))))

(re-frame/reg-sub
  ::design-provided?
  (fn [db _]
    (let [type (get-in db [:project-scope :step-2])]
      (get-in db [:project-scope :step-3 type :design-provided?]))))

(re-frame/reg-sub
  ::design-provided
  (fn [db _]
    (let [type (get-in db [:project-scope :step-2])]
      (get-in db [:project-scope :step-3 type :design-provided]))))

;TODO add logic to change :website to either mobile-app or website based on path

(re-frame/reg-sub
  ::deadline-type
  (fn [db _]
    (get-in db [:project-scope :step-4 :deadline-type])))

(re-frame/reg-sub
  ::deadline
  (fn [db _]
    (get-in db [:project-scope :step-4 :deadline])))

(re-frame/reg-sub
  ::start-date
  (fn [db _]
    (get-in db [:project-scope :step-4 :deadline])))
