(ns core-typed-demo.core
 (:require [clojure.core.typed :refer [ann]])
  (:gen-class))

(ann standard-creepiness-rule [Long -> Long])
(defn standard-creepiness-rule [age]
  (+ (/ age 2) 7))

(ann minimum-to-date [String Long -> String])
(defn minimum-to-date [your-name age]
  (str "hi " your-name "! You are " age " years old. "
    "it is not creepy for you to date anyone "
    (standard-creepiness-rule age) " or older."))

(ann -main [String * -> nil])
(defn -main [& args]
  (println (minimum-to-date "bob barker" 90)))
