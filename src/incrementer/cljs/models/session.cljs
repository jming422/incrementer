(ns incrementer.cljs.models.session
  (:require [reagent.core :as r]))

(def session (r/atom nil))
