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
    (set! (.-hash (.-location js/window)) "#/")
    (rf/dispatch [::events/set-active-view :start-view]))
  (defroute "/:path/" []
    (rf/dispatch [::events/set-active-view :select-type]))
  (defroute "/:path/website/" []
    (rf/dispatch [::events/set-active-view :web-select-primary]))
  (defroute "/:path/website/:primary/" []
    (rf/dispatch [::events/set-active-view :web-select-secondary]))
  (defroute "/:path/website/:primary/:secondary/" []
    (rf/dispatch [::events/set-active-view :web-select-platform]))
  (defroute "/:path/mobile-app/" []
    (rf/dispatch [::events/set-active-view :mobile-select-platform]))

  ;; --------------------
  (hook-browser-navigation!))
