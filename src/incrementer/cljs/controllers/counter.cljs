(ns incrementer.cljs.controllers.counter
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.xhr :as xhr]
            [incrementer.cljs.models.counter :as m]))

(defn retrieve-counter []
  (reset! m/counter nil)
  (xhr/send-get
    (routes/api :counter :id 1)
    :success-atom m/counter))

(defn dec-counter []
  (xhr/send-get
    (routes/api :modify-counter :id 1)
    :query-params {:delta -1}
    :success-atom m/counter))

(defn inc-counter []
  (xhr/send-get
    (routes/api :modify-counter :id 1)
    :query-params {:delta 1}
    :success-atom m/counter))
