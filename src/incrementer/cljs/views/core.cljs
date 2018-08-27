(ns incrementer.cljs.views.core
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.views.blog :as blog]
            [incrementer.cljs.views.account :as account]
            [incrementer.cljs.views.counter :as counter]
            [incrementer.cljs.views.components :as c]
            [reagent.session :as session]))

(defn index [params]
      [:div
       [:h1 "incrementer"]
       [:p
        "Brevity's default styles are pretty basic.  To tailor them to your project, see "
        [:a {:href "https://tachyons.io/docs/"} "the tachyons documentation"] "."]])

(defn four-o-four [params]
      [:div
       [:h1 "404: Page not found"]
       [:p ":("]])

(def views
  {:index index
   :login account/login
   :four-o-four four-o-four
   :blog blog/blog
   :blog-entry blog/blog-entry
   :counter counter/counter})

(defn page-contents [route]
      (let [page (:current-page route)
            params (:route-params route)]
           [:div.mw7.pv3.ph5.center
            [(views page) params]]))

(defn layout []
      (fn []
          (let [route (session/get :route)]
               [:div
                [c/header]
                ^{:key route} [page-contents route]
                [c/footer]])))
