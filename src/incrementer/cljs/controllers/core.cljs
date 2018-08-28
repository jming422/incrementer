(ns incrementer.cljs.controllers.core
  (:require [incrementer.cljs.controllers.blog :as blog]
            [incrementer.cljs.controllers.counter :as counter]))

(def page-initializers
  {:blog-entry blog/blog-entry
   :blog blog/blog-entries
   :counter counter/retrieve-counter})
