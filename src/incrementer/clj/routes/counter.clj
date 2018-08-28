(ns incrementer.clj.routes.counter
    (:require [incrementer.clj.models.sql :as sql]))

(defn get-counter
  "Returns the counter's value, or nil if the value is not found."
  [id]
  (let [params {:id id}]
    (:val (sql/counter-by-id sql/dbspec params))))

(defn modify-counter
  "Updates the specified counter by applying f to its current value"
  [id f]
  (if-let [old-val (get-counter id)]
    (let [new-val (f old-val)
          modified-rows (sql/modify-counter sql/dbspec {:id id :new-val new-val})]
            (if (= 1 modified-rows)
              {:status 200 :body {:val new-val}}
              {:status 500 :body "Something went wrong with the update!"}))
    {:status 404}))

(defn counter
  "Handles /api/v1/counter/"
  [req]
  (if-let [val (get-counter 1)] ; TODO: replace hard-coded id 1
    {:status 200
     :body {:val val}}
    {:status 404}))

(defn inc-counter
  "Handles /api/v1/counter/inc"
  [req]
  (modify-counter 1 inc)) ; TODO: replace hard-coded id 1