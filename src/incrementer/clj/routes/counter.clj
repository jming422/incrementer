(ns incrementer.clj.routes.counter
    (:require [incrementer.clj.models.sql :as sql]
              [clojure.walk :as walk]))

(defn parse-long [id]
  (try (Long/parseLong id)
   (catch NumberFormatException e nil)))

(defn get-db-counter
  "Returns the counter's value, or nil if the value is not found."
  [id]
  (let [params {:id id}]
    (:val (sql/counter-by-id sql/dbspec params))))

(defn update-db-counter [id f]
  (if-let [old-val (get-db-counter id)]
    (let [new-val (f old-val)
          modified-rows (sql/update-counter sql/dbspec {:id id :new-val new-val})]
            (if (= 1 modified-rows)
              {:status 200 :body {:val new-val}}
              {:status 500 :body "Something went wrong with the update!"}))
    {:status 404}))

(defn counter [{:keys [route-params]}]
  (let [{:keys [id]} route-params]
    (if-let [parsed-id (parse-long id)]
      (if-let [val (get-db-counter parsed-id)]
        {:status 200
         :body {:val val}}
        {:status 404})
      {:status 400})))

(defn modify-counter [{:keys [route-params query-params] :as req}]
  (let [{:keys [id]} route-params
        {:keys [delta]} (walk/keywordize-keys query-params)]
      (if-let [parsed-id (parse-long id)]
        (if-let [parsed-delta (parse-long delta)]
          (update-db-counter parsed-id (partial + parsed-delta))
          {:status 400})
        {:status 400})))
