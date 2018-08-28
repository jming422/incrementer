(ns incrementer.cljs.controllers.counter
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.xhr :as xhr]
            [incrementer.cljs.models.counter :as m]))

(defn retrieve-counter []
  (reset! m/counter nil)
  (xhr/send-get
    (routes/api :counter)
    :success-atom m/counter))

(defn inc-counter []
  (xhr/send-get
    (routes/api :inc-counter)
    :success-atom m/counter))
