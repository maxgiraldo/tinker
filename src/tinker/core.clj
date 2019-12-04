(ns tinker.core
  (:require 
    [clojure.java.io :as io]
    [clojure.data.csv :as csv]))

(defn data 
  "loads in csv file from data/ dir"
  [dataset]
  (let [valid-file-exts ["csv" "CSV"]
        dataset-name (name dataset)]
    (with-open [reader (io/reader (str "data/" dataset-name ".csv"))]
      (doall
        (csv/read-csv reader)))))

(def murders (data :murders))
;; TODO: accept various file extensions, e.g. csv, CSV
;; TODO: returned murders is properly formatted

