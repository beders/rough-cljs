(ns example
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.dom :as rdom]
            [rough-cljs.core :refer [Rough]]
            ))

(def logo [[:path "M 127.999,0 C 57.423,0 0,57.423 0,128.001 0,198.585 57.423,256.005 127.999,256.005 198.577,256.005 256,198.585 256,128.001 256,57.423 198.577,0 127.999,0"
            {:fill "white"}]
           [:path "m 123.318,130.303 c -1.15,2.492 -2.419,5.292 -3.733,8.272 -4.645,10.524 -9.789,23.33 -11.668,31.534 -0.675,2.922 -1.093,6.543 -1.085,10.558 0,1.588 0.085,3.257 0.22,4.957 6.567,2.413 13.66,3.74 21.067,3.753 6.743,-0.013 13.221,-1.127 19.284,-3.143 -1.425,-1.303 -2.785,-2.692 -4.023,-4.257 -8.22,-10.482 -12.806,-25.844 -20.062,-51.674"
            {:fill "#91dc47" :fillStyle "dots"}]
           [:path "m 92.97,78.225 c -15.699,11.064 -25.972,29.312 -26.011,49.992 0.039,20.371 10.003,38.383 25.307,49.493 3.754,-15.637 13.164,-29.955 27.275,-58.655 -0.838,-2.302 -1.793,-4.822 -2.862,-7.469 -3.909,-9.806 -9.551,-21.194 -14.586,-26.351 -2.567,-2.694 -5.682,-5.022 -9.123,-7.01"
            {:fill "#91dc47"}]
           [:path "m 181.394,198.367 c -8.1,-1.015 -14.785,-2.24 -20.633,-4.303 -9.836,4.884 -20.913,7.643 -32.642,7.643 -40.584,0 -73.483,-32.894 -73.488,-73.49 0,-22.027 9.704,-41.773 25.056,-55.24 -4.106,-0.992 -8.388,-1.571 -12.762,-1.563 -21.562,0.203 -44.323,12.136 -53.799,44.363 -0.886,4.691 -0.675,8.238 -0.675,12.442 0,63.885 51.791,115.676 115.671,115.676 39.122,0 73.682,-19.439 94.611,-49.169 -11.32,2.821 -22.206,4.17 -31.528,4.199 -3.494,0 -6.774,-0.187 -9.811,-0.558"
            {:fill "#63b132" :fillStyle "cross-hatch"}]
           [:path "m 159.658,175.953 c 0.714,0.354 2.333,0.932 4.586,1.571 15.157,-11.127 25.007,-29.05 25.046,-49.307 l -0.006,0 c -0.057,-33.771 -27.386,-61.096 -61.165,-61.163 -6.714,0.013 -13.164,1.121 -19.203,3.122 12.419,14.156 18.391,34.386 24.168,56.515 0.003,0.01 0.008,0.018 0.01,0.026 0.011,0.018 1.848,6.145 5.002,14.274 3.132,8.118 7.594,18.168 12.46,25.492 3.195,4.908 6.709,8.435 9.102,9.47"
            {:fill "#90b4fe"}]
           [:path "m 128.122,12.541 c -38.744,0 -73.016,19.073 -94.008,48.318 10.925,-6.842 22.08,-9.31 31.815,-9.222 13.446,0.039 24.017,4.208 29.089,7.06 1.225,0.706 2.388,1.466 3.527,2.247 9.05,-3.986 19.05,-6.215 29.574,-6.215 40.589,0.005 73.493,32.899 73.499,73.488 l -0.006,0 c 0,20.464 -8.37,38.967 -21.863,52.291 3.312,0.371 6.844,0.602 10.451,0.584 12.811,0.006 26.658,-2.821 37.039,-11.552 6.769,-5.702 12.44,-14.051 15.585,-26.569 0.615,-4.835 0.969,-9.75 0.969,-14.752 0,-63.882 -51.786,-115.678 -115.671,-115.678"
            {:fill "#5881d8" :fillStyle "cross-hatch"}]
           ])

(defn graph->code [graph]
  (str (vec (cons 'Rough (subvec graph 2))))
  )

(defn tile [title graph]
  [:div.col-sm-6
   [:div [:span {:style {:vertical-align "top"}} [:mark title]]]
   [:div graph]
   [:div [:pre {:style {:white-space "pre-wrap"}} (graph->code graph)]]
   ]
  )

(defn Showcase []
  (let [opts {:svg {:width 150 :height 150}}
        row-separator {:style {:margin-top "5px" :margin-bottom "5px" :padding "5px" :border-top "1px solid #80808026"}}
        ]
    [:div.container
     [:div.row
      (tile "Rectangle" [Rough opts [[:rectangle [10 10 100 100] {:fill "blue"}]]])
      (tile "Line" [Rough opts [[:line [10 10 100 100]]]])
      ]
     [:div.row row-separator
      (tile "Circle" [Rough opts [[:circle [75 75 50] {:fill "green" :fillStyle "dots"}]]])
      (tile "Ellipse" [Rough opts [[:ellipse [75 75 70 20] {:fill "red" :fillStyle "cross-hatch"}] [:ellipse [100 75 40 80] {:fill "yellow" :fillStyle "cross-hatch"}]]])
      ]
     [:div.row row-separator
      (tile "Linear Path" [Rough opts [[:linearPath [[0 70] [100 70] [100 75] [120 70] [100 60] [100 65] [0 65] [0 70]]]]])
      (tile "Polygon" [Rough opts [[:polygon [[75, 75] [50, 50] [10, 50] [40, 100]] {:fill "gray" :bowing 6}]]])
      ]
     [:div.row row-separator
      (tile "Arc" [Rough opts [[:arc [75 75 100 75 js/Math.PI, (* 1.6 js/Math.PI) true] {:fill "lime" :fillStyle "dots" :strokeWidth 0.8}]]])
      (tile "Curve" [Rough opts [[:curve [[0 150] [75 0] [100 150]]]]])
      ]
     [:div.row row-separator
      (tile "Path" [Rough opts [[:path "M10 80 A 45 55, 0, 1, 0, 125 75 L 125 70 Z" { :fill "purple" :hachureAngle 60, :hachureGap 5 }]]])
      ]
     ]))


(defn Title []
  (let [data        (atom logo)
        counter     (atom 0)
        interval-id (atom nil)]
    (reset! interval-id
            (js/setInterval
              (fn []
                (if (> @counter 20)
                  (js/clearInterval @interval-id)
                  (swap! counter inc)
                  )
                (swap! data shuffle)
                ) 500))
    (fn []
      [:div.container
       [:div.row
        [:div.col-sm [:span {:style {:vertical-align "top"}} [:mark.tertiary "Canvas"]] [Rough {:canvas {:width 256 :height 256}} @data]]
        [:div.col-sm [:span {:style {:vertical-align "top"}} [:mark "SVG"]] [Rough {:svg {:width 256 :height 256}} @data]]
        ]
       ]
      )
    )
  )

(defn Welcome []
  [:div
   [:h1 "Rough for CLJS"]
    [:span {:style {:padding-right "8px" :float "right"}} [:a {:href "https://github.com/beders/rough-cljs"} "RoughJS on"
                                      [:img {:style {:width "1rem" :height "1rem" :padding-left "5px" :padding-right "2px" :display "inline-block" :vertical-align "text-top"} :src "assets/GitHub-Mark-64px.png"}] "Github"]]
   [:p "Here are some examples of how to use Rough-cljs with reagent, for that hand-drawn appearance for all your boxes and arrows."]
   [:p "All the heavy lifting is done by the excellent " [:a {:href "https://roughjs.com/"} "RoughJS library of course."]]
   [:pre "[monoid/rough-cljs \"1.0.0\"]"]
   [:pre "(require '[rough-cljs.core :refer [Rough]])"]
   ]
  )

(defn start []
  (rdom/render [:div
                [Welcome]
                [Title]
                [Showcase]
                ]
               (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
