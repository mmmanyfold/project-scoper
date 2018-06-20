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
                        (let [pdf (js/jsPDF.)
                              img (-> canvas (.toDataURL "image/png"))]
                          (-> pdf
                              (.addImage img 0 10 0 0)
                              (.save "test.pdf"))))})))]
    [:div.pdf-prev
     [:h2 "PREVIEW"]
     [:button "send to mmmanyfold"]
     [:button {:on-click #(handle-download)} "download"]
     [:button "start over"]
     [:hr]
     [:div#pdf
      [:h1 "Project Scope - {product or service}*"]
      [:hr]
      [:p"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed tempus urna et pharetra pharetra massa massa ultricies. Diam donec adipiscing tristique risus nec. Vel quam elementum pulvinar etiam non. Nunc aliquet bibendum enim facilisis. Rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis. Cras ornare arcu dui vivamus arcu. Congue nisi vitae suscipit tellus mauris a. Gravida dictum fusce ut placerat orci. Lacus laoreet non curabitur gravida arcu ac tortor dignissim convallis. Ac felis donec et odio pellentesque diam volutpat commodo sed. In ornare quam viverra orci sagittis. Commodo odio aenean sed adipiscing diam donec. Sapien faucibus et molestie ac feugiat sed lectus vestibulum. Tortor vitae purus faucibus ornare suspendisse sed nisi lacus sed. Ipsum a arcu cursus vitae. Duis ut diam quam nulla porttitor massa. Viverra orci sagittis eu volutpat odio facilisis mauris. Etiam erat velit scelerisque in dictum non consectetur."]
      [:p"Cras fermentum odio eu feugiat pretium nibh ipsum. Sit amet volutpat consequat mauris. Feugiat pretium nibh ipsum consequat nisl vel. Iaculis at erat pellentesque adipiscing commodo elit at imperdiet. Aliquet nec ullamcorper sit amet risus nullam eget. Cursus mattis molestie a iaculis. Massa tincidunt dui ut ornare lectus sit amet est placerat. Amet volutpat consequat mauris nunc congue nisi vitae suscipit. Gravida in fermentum et sollicitudin ac. Porta nibh venenatis cras sed felis. Sem et tortor consequat id. Massa sed elementum tempus egestas. Turpis egestas sed tempus urna et pharetra pharetra. Tristique magna sit amet purus gravida. At risus viverra adipiscing at in tellus integer feugiat scelerisque."]
      [:p"Odio tempor orci dapibus ultrices in. A diam sollicitudin tempor id eu. Nunc faucibus a pellentesque sit amet porttitor. Quisque egestas diam in arcu cursus euismod. Sit amet risus nullam eget felis eget nunc lobortis mattis. Morbi tristique senectus et netus et malesuada fames ac turpis. Amet facilisis magna etiam tempor orci eu lobortis elementum nibh. Tellus id interdum velit laoreet id donec ultrices tincidunt arcu. Diam ut venenatis tellus in. Praesent elementum facilisis leo vel fringilla. Adipiscing elit duis tristique sollicitudin nibh sit amet commodo. Bibendum arcu vitae elementum curabitur vitae nunc. Sapien eget mi proin sed. Imperdiet sed euismod nisi porta lorem. Magna ac placerat vestibulum lectus mauris ultrices eros in cursus."]
      [:p"Magnis dis parturient montes nascetur ridiculus mus mauris vitae ultricies. Quam lacus suspendisse faucibus interdum. Morbi tincidunt ornare massa eget egestas. Ac feugiat sed lectus vestibulum mattis ullamcorper. Quisque non tellus orci ac auctor augue mauris. Venenatis tellus in metus vulputate eu scelerisque felis. Viverra maecenas accumsan lacus vel. Pharetra diam sit amet nisl suscipit. Dis parturient montes nascetur ridiculus mus mauris vitae ultricies leo. Aliquam eleifend mi in nulla posuere. Viverra accumsan in nisl nisi scelerisque. Imperdiet sed euismod nisi porta lorem. Elementum integer enim neque volutpat ac tincidunt vitae. Donec massa sapien faucibus et molestie ac. Varius vel pharetra vel turpis nunc. Feugiat nisl pretium fusce id velit ut tortor pretium viverra."]
      [:p"Aliquam vestibulum morbi blandit cursus. Purus sit amet volutpat consequat mauris nunc congue nisi. Facilisis mauris sit amet massa vitae tortor condimentum lacinia quis. Ac feugiat sed lectus vestibulum. Et leo duis ut diam quam nulla porttitor massa. Sit amet tellus cras adipiscing enim eu turpis. Ultricies mi quis hendrerit dolor magna eget est lorem. Justo eget magna fermentum iaculis. Tincidunt ornare massa eget egestas purus viverra accumsan in. Orci porta non pulvinar neque laoreet suspendisse interdum. Justo eget magna fermentum iaculis eu non diam. Id volutpat lacus laoreet non curabitur gravida arcu."]]]))


