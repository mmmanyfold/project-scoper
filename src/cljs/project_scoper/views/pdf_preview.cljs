(ns project-scoper.views.pdf-preview
  (:require cljsjs.jspdf
            cljsjs.html2canvas
            [project-scoper.components.controls :refer [controls]]))

(defn main []
  (let [handle-download
        (fn []
          (js/html2canvas
            (js/document.querySelector "#pdf")
            (clj->js {:onrendered
                      (fn [canvas]
                        (let [pdf (js/jsPDF. (clj->js {:format [8.5, 11]
                                                       :unit   "in"}))
                              img (-> canvas (.toDataURL "image/png"))]
                          (-> pdf
                              (.addImage img 0 0 0 0)
                              (.save "test.pdf"))))})))]
    (fn []
      [:div.pdf-prev
       [:h4 "PREVIEW"]
       [:button.pv3.ph4.ma2 {:on-click #(handle-download)} "download"]
       [:button.pv3.ph4.ma2 "send to mmmanyfold"]
       [:a {:href "/#/"} [:button.pv3.ph4.ma2 "start over"]]
       [:hr]
       [:div#pdf
        [:h1.f1.fw4 "Project Scope - "
         [:span.specs.fw5 "Website"]]
        [:div.f4 "Client Contact"]
        [:div.f4.specs "Sandeep Salter"]
        [:div.f4.specs "sandeep@pictureroom.shop"]
        [:hr.mt3]
        [:ol.f3.pt1.pb1.list-items
         [:li.mv3 [:div "Context: "
                   ;; OR "Starting from scratch"
                   [:span.specs "Building on an existing project"]]]

         ;; ONLY WEBSITE
         [:li.mv3 [:div "Website Purpose"]
                  [:ul
                   [:li [:span "Primary:"] [:span.specs "Online Shop"]]
                   ;; IF NIL: "N/A"
                   [:li [:span "Secondary:"] [:span.specs "Business Shop"]]]]

         ;; ONLY WEBSITE
         [:li.mv3 [:div "Platform: "
                   ;; IF NIL: "Open to any"
                   [:span.specs "Lightspeed"]]]

         ;; ONLY MOBILE APP
         ;[:li.mv3 [:div "Platform: "
         ;          [:span.specs "iOS & Android"]]]

         ;; ONLY WEBSITE & MOBILE APP
         [:li.mv3 [:div "Integrations"]
                  [:ul
                   ;; IF NIL: "None"
                   [:li [:span.specs "Facebook Events, Google Maps"]]]]
         [:li.mv3 [:div "Need user accounts? "
                   ;; IF TRUE: "Yes"
                   [:span.specs "No"]]]
         [:li.mv3 [:div "Visual Identity"]
                  [:ul
                   ;; IF NO: "Client needs branding services."
                   [:li [:span.specs "Client will provide Logo, Colors, Fonts, Icons, Images, Site Map, Site Mockups"]]]]

         ;; ONLY SERVICE, INSTALLATION, & NOT SURE
         ;[:li.mv3 [:div "Description"]
         ; [:p.specs "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque interdum rutrum sodales. Nullam mattis fermentum libero, non volutpat.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque interdum rutrum sodales. Nullam mattis fermentum libero, non volutpat."]]

         ;; FOR ALL
         [:li.mv3 [:div "Timeline"]
                  [:ul
                   [:li [:span "Proposed Start:" [:span.specs "July 1, 2018"]]]
                   [:li [:span "Deadline:" [:span.specs "September 5, 2018 (soft)"]]]]]

         ;; ONLY IF NOT NIL
         [:li.mv3 [:div "Comments"]
                  [:p.specs "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque interdum rutrum sodales. Nullam mattis fermentum libero, non volutpat.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque interdum rutrum sodales. Nullam mattis fermentum libero, non volutpat."]]]

        [:hr.mt4.mb3]
        [:div.footer.tr.pt2.flex.items-center.w-100.justify-end
         [:p "generated with"
             [:br] "project-scoper.mmmanyfold.com"]
         [:div [:img.logo {:src "img/logo-purple.png"}]]]]])))
