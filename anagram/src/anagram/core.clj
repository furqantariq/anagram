(ns anagram.core)
(use '[clojure.string :only (split lower-case join)])



(defn input
  [file_name] (-> 
                (slurp file_name :encoding "ISO-8859-1")
                (split  #"\s+")
))

(defn output [data]   
  (spit "output.txt" (println-str "WORDS    ANAGRAM") :encoding "ISO-8859-1")
  (doseq [x data]
    (let [w (first x)
          r (rest x)]
    (spit "output.txt" (println-str w "     " r) :encoding "ISO-8859-1" :append true)
    ))
  )
(defn output_stat
  [tag data]   (spit "output.txt" 
                     (println-str tag " : " data ) :encoding "ISO-8859-1" :append true)
  )


(defn anagram [xy result]
  (let [word (first xy)
        y (rest xy)
        r2 (update result (apply str (sort (lower-case word))) conj word)]
   (if (not-empty y)
      (recur y r2)
      r2)))


(defn find-anagram [file]
  (let [result (anagram (input file) {})
        all_key (keys result)
        all_val (vals result)]
    (output all_val)
    (output_stat "Total Anagram" (- (reduce + (map count all_val)) (count (keys all_key))))
    (output_stat "Words with Anagram" (count (filter #(> (count %) 1) all_val)))
    (output_stat "Words without Anagram" (count (filter #(= (count %) 1) all_val)))

    )
  )

(find-anagram "C:\\Users\\furqa\\Downloads\\eventyr.txt")


