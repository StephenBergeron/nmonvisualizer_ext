(defproject nmonvisualizer_ext "0.1.0-SNAPSHOT"
  :description "Extension to the nmonvisualizer tool available on github"
  :url "http://too.poor.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [clojure-csv/clojure-csv "2.0.2"]]
  :plugins [[lein-auto "0.1.3"] [lein-ancient "0.6.15"]]
  :main ^:skip-aot nmonvisualizer-ext.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
