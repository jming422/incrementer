(ns incrementer.cljs.controllers.blog
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.xhr :as xhr]
            [incrementer.cljs.models.counter :as m]))

(defn retrieve-counter []
  (reset! m/counter 0)
  (xhr/send-get
    (routes/api :counter)
    :success-atom m/counter))
;TODO: Implement the above API route!
(defn modify [f]
  (swap! m/counter f)
  #_"TODO: Send request to API to update counter there!")
