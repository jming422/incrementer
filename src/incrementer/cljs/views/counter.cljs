(ns incrementer.cljs.views.counter
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.views.components :as c]
            [incrementer.cljs.models.counter :as ct]))

(defn counter [params]
      [:div
       [:h1 "incrementer: Counter"]
       (if @ct/count-atom
         [:div
          [:h3 @ct/count-atom]
          [c/button "Do the thing" (fn [] (swap! ct/count-atom inc))]]
         [c/loading-spinner])])
