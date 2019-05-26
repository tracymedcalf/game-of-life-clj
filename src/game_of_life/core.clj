(ns game-of-life.core
  (:gen-class))

(defn random-world [size]
  (vec (take size (repeatedly #(rand-int 2)))))

(defn input [msg]
  (println msg) (read-line))

(defn str->int [s]
  (Integer. (re-find #"[0-9]*" s)))

(def int-input (comp str->int input))

(defn indices-in-bounds [col indices]
  (assert (vector? col))
  (for [index indices
    :when (some? (get col index))] index))

(defn dead>alive [neighbors'-indices world]
  (let [neighbors (mapv world (indices-in-bounds world neighbors'-indices))]
    (if (> (apply + neighbors)
     (/ (count neighbors) 2)) 1 0)))


(defn neighbors'-indices [width i]
  [(- i width 1) (- i width) (- i width -1)
   (- i 1) i (+ i 1)
   (+ i width -1) (+ i width) (+ i width 1)])

(defn new-world [neighbors'-indices old-world indices]
  (mapv #(dead>alive (neighbors'-indices %) old-world) indices))

(defn print-grid [coll width]
  (loop [coll coll]
    (when (seq coll) (println (take width coll))
    (recur (drop width coll)))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [width (int-input "width?")
        size (* width (int-input "height?"))]
    (loop [world (random-world size) user-input ""]
      (if (not= "q" user-input)
      (do (println "'q<enter>' to quit") (print-grid world width)
        (recur (new-world #(neighbors'-indices width %) world (range size))
         (read-line)))))))
