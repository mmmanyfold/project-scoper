(ns project-scoper.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [secretary.core :as secretary]
            [goog.events :as gevents]
            [goog.history.EventType :as EventType]
            [re-frame.core :as rf]
            [project-scoper.events :as events]))

(defn hook-browser-navigation! []
  (doto (History.)
    (gevents/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute "/" []
            (rf/dispatch [::events/set-active-view :step-1]))
  (defroute "/step/2" []
            (rf/dispatch [::events/set-active-view :step-2]))
  (defroute "/step/3/website/:step" [step]
            (case step
              "a" (rf/dispatch [::events/set-active-view :web-a])
              "b" (rf/dispatch [::events/set-active-view :web-b])
              "c" (rf/dispatch [::events/set-active-view :web-c])
              "d" (rf/dispatch [::events/set-active-view :integrations])
              "e" (rf/dispatch [::events/set-active-view :users])
              "f" (rf/dispatch [::events/set-active-view :design])))
  (defroute "/step/3/mobile-app/:step" [step]
            (case step
              "a" (rf/dispatch [::events/set-active-view :mobile-a])
              "b" (rf/dispatch [::events/set-active-view :integrations])
              "c" (rf/dispatch [::events/set-active-view :users])
              "d" (rf/dispatch [::events/set-active-view :design])))
  (defroute "/step/3/:type" [type]
            (when (some #{type} ["service" "installation" "not-sure"])
              (rf/dispatch [::events/set-active-view :description])))
  (defroute "/step/4" []
            (rf/dispatch [::events/set-active-view :step-4]))
  (defroute "/step/5" []
            (rf/dispatch [::events/set-active-view :step-5]))
  (defroute "/step/6" []
            (rf/dispatch [::events/set-active-view :step-6]))
  (defroute "/pdf" []
            (rf/dispatch [::events/set-active-view :pdf-preview]))

  ;; --------------------
  (hook-browser-navigation!))
