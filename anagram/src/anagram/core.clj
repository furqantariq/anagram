(ns anagram.core)
(use '[clojure.string :only (split lower-case join)])



(defn in_file 
  [file_name] (-> 
                (slurp file_name :encoding "ISO-8859-1")
                (split  #"\s+")
))

(defn out_file 
  [file_name data] (-> 
                (spit file_name data :encoding "ISO-8859-1")
))


(defn anagram [xy result]
  (let [word (first xy)
        y (rest xy)
        r2 (update result (apply str (sort (lower-case word))) conj word)]
   (if (not-empty y)
      (recur y r2)
      r2)))
 
(anagram ["aa","bb","ab","ba"] {})
(out_file "C:\\Users\\furqa\\Downloads\\eventyr.txt")
(println (join \newline (vals (anagram ["aa","bb","aB","ba"] {}))))
(- (reduce + (map count (vals (anagram ["aa","bb","aB","ba"] {})))) (count (keys (anagram ["aa","bb","aB","ba"] {}))))


