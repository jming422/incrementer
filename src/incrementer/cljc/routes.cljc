(ns incrementer.cljc.routes
    (:require [bidi.bidi :as bidi]
              [incrementer.cljc.utils :as u]))

(def page-routes
  (u/router "/"
            (u/page "" :index)
            (u/page "login" :login)
            (u/context "blog"
              (u/page "/" :blog)
              (u/page ["/entry/" :id] :blog-entry))
            (u/page "counter" :counter)))

(def api-routes
  (u/router "/api/v1"
            (u/context "/session"
                       (u/POST :login)
                       (u/GET :get-account-info)
                       (u/DELETE :logout))
            (u/context "/blog"
                       (u/GET "/" :blog)
                       (u/GET ["/entry/" :id] :blog-entry))
            (u/context "/admin"
                       (u/POST "/blog/entry" :new-blog-entry)
                       (u/DELETE ["/blog/entry/" :id] :delete-blog-entry))
            (u/context "/counter"
                       (u/GET "/" :counter)
                       (u/GET "/inc" :inc-counter))))

(def page (partial bidi/path-for page-routes))
(def api (partial bidi/path-for api-routes))
