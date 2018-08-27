(ns incrementer.cljs.views.blog
  (:require [incrementer.cljc.routes :as routes]
            [incrementer.cljs.views.components :as c]
            [incrementer.cljs.models.blog :as b]))

(defn blog []
      [:div
       [:h1 "incrementer: Blog"]
       (if @b/all-entries
         [:div (for [{:keys [id title]} @b/all-entries]
                    ^{:key id}
                    [:div
                     [:a {:href (routes/page :blog-entry :id id)} title]])]
         [c/loading-spinner])])

(defn blog-entry []
      (let [{:keys [title content]} @b/blog-entry]
           [:div
            [:h1 (or title [c/loading-spinner])]
            [:div
             [:p (or content "")]
             [:a {:href (routes/page :blog)} "Back to Blog"]]]))
