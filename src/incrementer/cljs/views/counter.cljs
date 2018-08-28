(ns incrementer.cljs.views.counter
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.views.components :as c]
            [incrementer.cljs.models.counter :as m]
            [incrementer.cljs.controllers.counter :as ctrl]))

(defn counter [params]
      [:div
       [:h1 "incrementer: Counter"]
       (if @m/counter
         [:div
          [:h3 @m/counter]
          [c/button "Do the thing" #(ctrl/modify inc)]]
         [c/loading-spinner])])
