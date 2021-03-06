{:databases {:name2key {:type :redis
                        :host "localhost"
                        :db 0
                        :key #(subs (first %) 0 3)
                        :subkey #(first %)}
             :key2name {:type :redis
                        :host "localhost"
                        :db 1
                        :key #(subs (first %) 0 4)
                        :subkey #(first %)
                        :topath (fn [key subkey] subkey)}
             :httpdb-users {:type :redis
                            :host "localhost"
                            :db 2
                            :key "httpdb-users"
                            :subkey #(apply taoensso.carmine/kname %)}
             :httpdb-data {:type :redis
                           :host "localhost"
                           :db 2
                           :key #(apply taoensso.carmine/kname [(first %) :data])
                           :subkey #(apply taoensso.carmine/kname (rest %))}}
 :name2key {:in-world-url #(let [{:keys [status headers body error] :as resp} @(http/get "http://w-hat.com/uuid-url.txt")] body)}}
