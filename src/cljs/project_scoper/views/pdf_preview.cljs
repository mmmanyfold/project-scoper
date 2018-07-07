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
                        (let [pdf (js/jsPDF. #js {:format #js [8.5, 11] :unit "in"})
                              img (-> canvas (.toDataURL "image/png"))]
                          (-> pdf
                              (.addImage img 0 0 10 0)
                              (.save "test.pdf"))))})))]
    (fn []
      [:div.pdf-prev
       [:h4 "PREVIEW"]
       [:button.pv3.ph4.ma2 {:on-click #(handle-download)} "download"]
       [:button.pv3.ph4.ma2 "send to mmmanyfold"]
       [:a {:href "/#/"} [:button.pv3.ph4.ma2 "start over"]]
       [:hr.mb0]
       [:div#pdf
        [:h1.f1.fw5.mt0 "Project Scope - "
         [:span.title.fw5 "Website"] [:span "*"]]
        [:p.measure.f4-ns "Client Contact"]
        [:p.measure.f4-ns.contact "Sandeep Salter"]
        [:p.measure.f4-ns.contact "sandeep@pictureroom.shop"]
        [:hr.ma2]
        [:h2.f2.pv3.fw5.redish "*Build on an existing project"]
        [:ol.f3
         [:li.mv4 [:div "PURPOSE"
                   [:ul
                    [:li [:span "Primary: "] [:span.redish "Online Shop"]]
                    [:li [:span "Secondary: "] [:span.redish "Business Shop"]]]]]
         [:li.mv4 [:p "PLATFORM"]
          [:p.redish "Lightspeed"]]
         [:li.mv4 [:p "INTEGRATIONS"]
          [:p.redish "Facebook Events"]]
         [:li.mv4 [:p "USER ACCOUNTS?"]
          [:p.redish "No"]]
         [:li.mv4 [:p "VISUAL IDENTITY"]
          [:p.redish "Client will provide: Logo, Colors, Fonts, Icons, Images, Site Map, Site Mockups"]]
         [:li.mv4 [:p "TIMELINE"]
          [:p "Soft Deadline: " [:span.redish "September 5, 2018"]]
          [:p "Proposed Start: " [:span.redish "July 1, 2018"]]]
         [:li.mv4 [:p "COMMENTS"]
          [:p.redish "We would like the ability to change out Featured Artist content & Staff Picks on a regular basis"]]
         [:hr.ma2]
         [:div
          [:div.tr.flex.items-center.w-100.justify-end
           [:span
            [:small "generated with"]
            [:br]
            [:small "project-scoper.mmmanyfold.com"]]
           [:div [:img.logo {:src "img/logo-purple.png"}]]]]]]])))
