(ns sample-github-spa.repository.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::repositories
 (fn [db]
   (-> db :repository :repositories)))

(re-frame/reg-sub
 ::should-load-more?
 (fn [db]
   (zero? (mod (-> db :repository :repositories count)
               (-> db :repository :per-page)))))

(re-frame/reg-sub
 ::get-repository-by-id
 (fn [db [_ id]]
   (some->> db
            :repository
            :repositories
            (filter #(-> % :id (= id)))
            first)))
