(ns incrementer.clj.core
  (:gen-class)
  (:require [incrementer.clj.routes.core :as r]
            [incrementer.clj.utils.core :as u]
            [incrementer.clj.models.sql :as sql]
            [environ.core :as environ]
            [immutant.web :as server])
  (:import [com.opentable.db.postgres.embedded EmbeddedPostgres]))

(def host (environ/env :host))
(def port (environ/env :port))

(defn -main [& args]
  (sql/init!)
  (if (= "development" (environ/env :environment))
    (server/run-dmc r/app :host host :port port)
    (server/run r/app :host host :port port)))
