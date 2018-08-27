(ns incrementer.cljs.models.counter
  (:require [reagent.core :as r]))

(def count-atom (r/atom 0))
