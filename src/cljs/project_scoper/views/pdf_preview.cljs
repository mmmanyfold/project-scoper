(ns project-scoper.views.pdf-preview
  (:require cljsjs.jspdf
            cljsjs.html2canvas
            [project-scoper.components.controls :refer [controls]]
            [project-scoper.components.bubble :refer [bubble]]))

(defn main []
  (let [doc (js/jsPDF.)
        handle-download
        (fn []
          (js/html2canvas
            (js/document.querySelector "#pdf")
            (clj->js {:onrendered
                      (fn [canvas]
                        (let [img (-> canvas (.toDataURL "image/png"))]
                          (-> doc
                              (.addImage img 0 0)
                              (.save "test.pdf"))))})))]
    [:div.pdf-prev
     [:h2 "PREVIEW"]
     [:button "send to mmmanyfold"]
     [:button {:on-click #(handle-download)} "download"]
     [:button "start over"]
     [:hr]
     [:div#pdf
      [:h1 "Project Scope - {product or service}*"]
      [:hr]]]))


