(ns nmonvisualizer-ext.core-test
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [clojure.test :as t]
            [nmonvisualizer-ext.core :as sut]))

(def csv-dir
  (str (System/getenv "CACHEDIR")
       "/" (System/getenv "simulation")
       "/nmon/rawdata"))

(def csv-files
  (remove
   (fn [x] (string/includes? x "_processes.csv"))
   (filter
    (fn [x] (string/includes? x "-bgp-"))
    (.list (io/file csv-dir)))))

(def csv-file
  (str csv-dir "/" (first csv-files)))

(t/deftest csv-files-length
  "we can process at least one file AND ONLY one file for now"
  (clojure.pprint/pprint csv-files)
  (clojure.pprint/pprint csv-file)
  (t/testing (t/is (= 1 (count csv-files)))))

(t/deftest simple-model
  (let [res (sut/simple-model csv-file)]
    (clojure.pprint/pprint (last res))
    (t/testing (t/is (= 360 (count res))))))
