(ns nmonvisualizer-ext.core
  (:gen-class)
  (:require [clojure-csv.core :as clojure-csv.core]

            [clojure.string :as string]
            [clojure.pprint]))

(defn- keywordize-
  "converts string to keyword with all lowercase and dash instead of spaces"
  [k]
  (keyword (string/lower-case (string/replace k #" " "-"))))

(defn- keywordize-map-
  "takes a map, converts string keys to keyword keys"
  [m]
  (into {} (for [[k v] m] [(keywordize- k) v])))

; todo - simplify if no plan to use keywordize
(defn- parse-csv
  [csv & {key :key :as opts}]
  (let [opts   (vec (reduce concat (vec opts)))
        c      (apply clojure-csv.core/parse-csv csv opts)
        partial1 (rest c)
        output (map (partial zipmap (first c)) partial1)
        ]
    (if (= key :keyword) (map keywordize-map- output) output)))

; todo - simplify if no plan to use keywordize
; :key :keyword
(defn from-csv
  ([path] (parse-csv (slurp path))))

(defn to-epoch
  [date time]
  (let [ms (.getTime
            (.parse
             (java.text.SimpleDateFormat.
              "yyyy-MM-dd HH:mm:ss") (str date " " time)))]
    (/ ms 1000)))

(defn simple-model
  ([in]
   (let [orig (from-csv in)
         model (map
                (fn [x]
                  {
                   "tstamp" (to-epoch (x "Date") (x "Time"))
                   "CPU_ALL CPU%" (x "CPU_ALL CPU%")
                   }) orig)]
     model)))

(defn to-csv
  ([data out]
   (let [csv (string/join "\n" (map (fn [x] (str (x "tstamp") "," (x "CPU_ALL CPU%"))) data))]
    (with-open
      [w (clojure.java.io/writer out :append false)]
      (.write w csv)))))

;; "CPU_ALL CPU%" "61.100",
;; "CPU_ALL Sys%" "4.400",
;; "CPU_ALL Wait%" "0.000",
;; "CPU_ALL User%" "56.700"
;; "Time" "14:27:18"
;; "Date" "2018-05-29",



(defn -main
  [& args]
  (clojure.pprint/pprint args)
  (cond
    (= 2 (count args)) (clojure.pprint/pprint (to-csv (simple-model (first args)) (second args)))
    :else              (println "please specify input and output ")))
