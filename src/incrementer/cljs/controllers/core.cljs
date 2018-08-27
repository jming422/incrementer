(ns incrementer.cljs.controllers.core
  (:require [incrementer.cljs.controllers.blog :as blog]))

(def page-initializers
  {:blog-entry blog/blog-entry
   :blog blog/blog-entries})
