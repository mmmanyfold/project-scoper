(ns project-scoper.app
  (:require [re-frame.core :as rf]
            [re-com.core :as re-com]
            [project-scoper.subs :as subs]
            [project-scoper.views.step-1 :refer [step-1-view]]
            [project-scoper.views.step-2 :refer [step-2-view]]
            [project-scoper.views.step-3.web-a :refer [web-a-view]]
            [project-scoper.views.step-3.web-b :refer [web-b-view]]
            [project-scoper.views.step-3.web-c :refer [web-c-view]]
            [project-scoper.views.step-3.mobile-a :refer [mobile-a-view]]
            [project-scoper.views.step-3.shared-users :refer [users-view]]
            [project-scoper.views.step-3.shared-integrations :refer [integrations-view]]
            [project-scoper.views.step-3.shared-design :refer [design-view]]))

(defn- views [view-name]
       (case view-name
             :step-1 [step-1-view]
             :step-2 [step-2-view]
             :web-a [web-a-view]
             :web-b [web-b-view]
             :web-c [web-c-view]
             :mobile-a [mobile-a-view]
             :users [users-view]
             :integrations [integrations-view]
             :design [design-view]
             [:div [:h1 404] [:p [:a {:href "/"} "Return home"]]]))

(defn app-view []
  (let [active-view @(rf/subscribe [::subs/active-view])]
    [:div
     [:div.nav
      [:div
        [:span [:a {:href "http://mmmanyfold.com" :target "_blank"} "brought to you by mmmanyfold"]]]]
     [:header
      [:div.img-wrapper
       [:a.logo {:href "/"}
        [:img {:src "img/logo-graydient-invert.png"}]]]
      [:h1 "project scoper"]
      [:p.subtitle "define your digital needs"]]
     [:div.view-container
      [views active-view]]]))
