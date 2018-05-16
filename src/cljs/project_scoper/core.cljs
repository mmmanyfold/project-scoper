(ns project-scoper.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [project-scoper.events :as events]
            [project-scoper.routes :as routes]
            [project-scoper.app :as app]
            [project-scoper.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [app/app-view]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
