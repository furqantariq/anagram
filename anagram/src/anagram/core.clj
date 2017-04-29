(ns anagram.core)


(let [alphaprime {\a 2, \b 3}]
(defn anagram
  ([xy result] (let [word (first xy)
             y (rest xy)]
           (let [result (update result (reduce + (map alphaprime (seq word))) conj word)]
           (println result)
            (if (not-empty y) (anagram y result))
            ))
     )
))

 
 (anagram ["aa","bb","ab","ba"] {})
 