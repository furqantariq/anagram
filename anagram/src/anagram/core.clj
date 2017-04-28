(require '[clojure.core.match :refer [match]])

(ns anagram.core)

(def prime [:a 2 :b 3 :c 5 :d 7 :e 11 :f 13 :g 17 :h 19])

(update {8 ["abb"]} (reduce + (map {\a 2, \b 3} (seq "bab"))) conj "bab")

(defn anagram
  ([] 0)
 ([xy] (let [x (first xy)
             y (rest xy) ] 
           (reduce + (map {\a 2, \b 3} (seq x)) )
            (anagram y)
           )
       )
 )
