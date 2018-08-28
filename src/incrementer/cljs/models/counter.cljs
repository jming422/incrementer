(ns incrementer.cljs.models.counter
  (:require [reagent.core :as r]))

(def counter (r/atom nil))
