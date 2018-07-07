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
  (defroute "/step/3/web/a" []
    (rf/dispatch [::events/set-active-view :web-a]))
  (defroute "/step/3/web/b" []
    (rf/dispatch [::events/set-active-view :web-b]))
  (defroute "/step/3/web/c" []
    (rf/dispatch [::events/set-active-view :web-c]))
  (defroute "/step/3/web/d" []
    (rf/dispatch [::events/set-active-view :integrations]))
  (defroute "/step/3/web/e" []
    (rf/dispatch [::events/set-active-view :users]))
  (defroute "/step/3/web/f" []
    (rf/dispatch [::events/set-active-view :design]))
  (defroute "/step/3/mobile/a" []
    (rf/dispatch [::events/set-active-view :mobile-a]))
  (defroute "/step/3/mobile/b" []
    (rf/dispatch [::events/set-active-view :integrations]))
  (defroute "/step/3/mobile/c" []
    (rf/dispatch [::events/set-active-view :users]))
  (defroute "/step/3/mobile/d" []
    (rf/dispatch [::events/set-active-view :design]))
  (defroute "/step/4" []
    (rf/dispatch [::events/set-active-view :step-4]))

  ;; --------------------
  (hook-browser-navigation!))
