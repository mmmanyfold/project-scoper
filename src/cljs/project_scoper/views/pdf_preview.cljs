(ns project-scoper.views.pdf-preview
  (:require cljsjs.jspdf
            cljsjs.html2canvas
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.components.bubble :refer [bubble]]))

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
        [:h1.f1.fw5 "Project Scope - "
         [:span.title.fw5 "Website"] [:span "*"]]
        [:div.measure.f5-ns "Client Contact"]
        [:div.measure.f5-ns.contact "Sandeep Salter"]
        [:div.measure.f5-ns.contact "sandeep@pictureroom.shop"]
        [:hr]
        [:h2.f2.pv1.fw5.redish "*Build on an existing project"]
        [:ol.f3
         [:li.mv3 [:div "PURPOSE"
                   [:ul
                    [:li [:span "Primary: "] [:span.redish "Online Shop"]]
                    [:li [:span "Secondary: "] [:span.redish "Business Shop"]]]]]
         [:li.mv3 [:div "PLATFORM"]
          [:div.redish "Lightspeed"]]
         [:li.mv3 [:div "INTEGRATIONS"]
          [:div.redish "Facebook Events"]]
         [:li.mv3 [:div "USER ACCOUNTS?"]
          [:div.redish "No"]]
         [:li.mv3 [:div "VISUAL IDENTITY"]
          [:div.redish "Client will provide: Logo, Colors, Fonts, Icons, Images, Site Map, Site Mockups"]]
         [:li.mv3 [:div "TIMELINE"]
          [:div "Proposed Start: " [:span.redish "July 1, 2018"]]
          [:div "Soft Deadline: " [:span.redish "September 5, 2018"]]]
         [:li.mv3 [:div "COMMENTS"]
          [:div.redish "We would like the ability to change out Featured Artist content & Staff Picks on a regular basis"]]
         [:hr.ma2]
         [:div
          [:div.tr.flex.items-center.w-100.justify-end
           [:span
            [:small "generated with"]
            [:br]
            [:small "project-scoper.mmmanyfold.com"]]
           [:div [:img.logo {:src "img/logo-purple.png"}]]]]]]])))
