(ns project-scoper.db)

(def default-db
  {:active-view nil
   :current-path (.-hash (.-location js/window))})
