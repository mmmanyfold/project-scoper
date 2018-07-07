(ns project-scoper.helpers
  (:require [camel-snake-kebab.core :refer [->kebab-case]]
            [cljs.spec.alpha :as s]
            [clojure.string :as string]))

(s/def ::string? string?)

(defn check-and-throw
  "throw an exception if value doesn't match the spec"
  [a-spec val]
  (when-not (s/valid? a-spec val)
    (throw (ex-info (str "spec failed because: " (s/explain-str a-spec val)) {}))))

(defn keywordize-name [name]
  (let [name (string/replace name "/" "slash")]
    (check-and-throw ::string? name)
    (-> name ->kebab-case keyword)))

(defn unkeywordize [keyword]
  (let [replace-slash (string/replace (name keyword) "slash" "/")]
    (string/replace replace-slash "-" " ")))
