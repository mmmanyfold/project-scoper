(ns project-scoper.db)

(def default-db
  {:active-view nil
   :type nil
   :path nil
   :primary nil

   ;; new data model
   :project-scope

   {:step-1 #{:start-from-scratch
              :build-on-existing-project}

    ;; only one is true at a time
    :step-2 {:website? false
             :mobile-app? false
             :service-integration? false
             :not-sure? false
             :installation? false}

    :step-3 {:website {:primary #{:gallery-portfolio
                                  :sell-online
                                  :blogging
                                  :custom-platform
                                  :online-presence}
                       :secondary []
                       :platform-name nil
                       :integrations []
                       :user-accounts? false
                       :design-provided? false
                       :design-provided []}
             :mobile-app {:platform #{:ios
                                      :android
                                      :both
                                      :any}
                          :integrations []
                          :user-accounts? false
                          :design-provided? false
                          :design-provided []}
             ;; text box for the following
             :service-integration nil
             :installation nil
             :not-sure nil}

    ;; timeline
    :step-4 {:deadline-type #{:hard :soft}
             :deadline nil ;; use Date obj
             :start-date nil}

    ;; comments / limit to 280 char
    :step-5 nil

    ;; contact-info
    :step-6 {;; limit to 52 char
             :name nil
             ;; validate email
             :email nil}}})






