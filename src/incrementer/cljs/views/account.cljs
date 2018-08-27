(ns incrementer.cljs.views.account
  (:require [reagent.core :as r]
            [incrementer.cljs.controllers.session :as s]
            [incrementer.cljc.routes :as routes]
            [incrementer.cljs.xhr :as xhr]
            [incrementer.cljs.views.components :as c]))

(defn login []
      (let [email (r/atom "")
            password (r/atom "")
            show-kiwi-bird (r/atom false)
            message (r/atom "")]
           (fn []
               [:form.mw5.center
                [:div @message]
                [c/input :label-text "Email Address" :id :email :type :email :value email]
                [c/input :label-text "Password" :id :password :type :password :value password]
                [c/input
                 ; This is just an example to show that you can easily create a labelled checkbox.
                 :label-text "Show a kiwi bird?"
                 :id :show-kiwi-bird
                 :type :checkbox
                 :value show-kiwi-bird]
                (when @show-kiwi-bird
                      [:div.tr.h1
                       [:i.fas.fa-kiwi-bird.fr.mv2.green]])
                [c/button "Login"
                 (fn [e]
                     (.preventDefault e)
                     (s/login @email @password message))]])))
