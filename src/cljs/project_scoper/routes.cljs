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
  (defroute "/:path/" []
    (rf/dispatch [::events/set-active-view :step-2]))
  (defroute "/:path/website/" []
    (rf/dispatch [::events/set-active-view :web-a]))
  (defroute "/:path/website/:primary/" []
    (rf/dispatch [::events/set-active-view :web-b]))
  (defroute "/:path/website/:primary/:secondary/" []
    (rf/dispatch [::events/set-active-view :web-c]))
  (defroute "/:path/mobile-app/" []
    (rf/dispatch [::events/set-active-view :mobile-a]))
  (defroute "/test" []
    (rf/dispatch [::events/set-active-view :users]))

  ;; --------------------
  (hook-browser-navigation!))
