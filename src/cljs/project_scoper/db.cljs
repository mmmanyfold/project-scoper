(ns project-scoper.db)

(def default-db
  {:active-view nil
   :type nil
   :path nil
   :primary nil

   ;; new data model
   :project-scope

   {:step-1 nil ;:start-from-scratch, or :build-on-existing-project

    ;; only one is true at a time
    :step-2 nil ;:website, :mobile-app, :service-integration, :not-sure, or :installation
    :step-3 {:website {:primary nil ;:gallery-portfolio, :sell-online, :blogging, :business-website, :other
                       :secondary #{}
                       :platform? nil
                       :platform-name nil
                       :integrations []
                       :user-accounts? false
                       :design-provided? false
                       :design-provided []}
             :mobile-app {:platform nil ;:ios, :android, :both, or :any
                          :integrations []
                          :user-accounts? false
                          :design-provided? false
                          :design-provided []}
             ;; text box for the following
             :service-integration nil
             :installation nil
             :not-sure nil}

    ;; timeline
    :step-4 {:deadline-type nil ;:hard or :soft
             :deadline nil ;; use Date obj
             :start-date nil}

    ;; comments / limit to 280 char
    :step-5 nil

    ;; contact-info
    :step-6 {;; limit to 52 char
             :name nil
             ;; validate email
             :email nil}}})






