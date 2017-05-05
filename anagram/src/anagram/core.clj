(ns anagram.core)
(use '[clojure.string :only (split lower-case)])



(defn read_file 
  [file_name] (-> 
                (slurp file_name :encoding "ISO-8859-1")
                (lower-case)
                (split  #"\s+")
))

(defn anagram [xy result]
  (let [word (first xy)
        y (rest xy)
        r2 (update result (apply str (sort word)) conj word)]
    (println result)
    (if (not-empty y)
      (recur y r2)
      r2)))
 
 (anagram ["aa","bb","ab","ba"] {})
(read_file "C:\\Users\\furqa\\Downloads\\eventyr.txt")

 