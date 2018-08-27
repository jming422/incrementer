(ns incrementer.cljs.controllers.blog
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.xhr :as xhr]
            [incrementer.cljs.models.blog :as m]))

(defn blog-entries []
      (xhr/send-get
        (routes/api :blog)
        :success-atom m/all-entries))

(defn blog-entry [{:keys [id]}]
      (reset! m/blog-entry nil)
      (xhr/send-get
        (routes/api :blog-entry :id id)
        :success-atom m/blog-entry))
