(ns incrementer.cljs.views.counter
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.views.components :as c]
            [incrementer.cljs.models.counter :as m]
            [incrementer.cljs.controllers.counter :as ctrl]))

(defn counter [params]
  [:div
    [:h1 "The Incrementer"]
    (if @m/counter
      [:div
        [:h1.tc (:val @m/counter)]
        [:div.center.flex.w-100
          [:div.w-50.mr2
            [c/cool-button "Down" #(ctrl/dec-counter)]]
          [:div.w-50
            [c/cool-button "Up" #(ctrl/inc-counter)]]]
        [:p.normal "This is a paragraph"]]
      [c/loading-spinner])])
