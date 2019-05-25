(ns game-of-life.core
  (:gen-class))

(defn random-world [size]
  (take size (repeatedly #(rand-int 2))))

(defn input [msg]
  (println msg) (read-line))

(defn str->int [s]
  (Integer. (re-find #"[0-9]*" s)))
; (str->int "778\n")

(def int-input (comp str->int input))

(defn cartesian-product [vec1 vec2]
  (for [x vec1 y vec2] [x y]))
; (cartesian-product [1 2 3] ['a 'b 'c])

(defn neighbors'-xy's [x y]
  (cartesian-product
    [(dec x) x (inc x)]
    [(dec y) y (dec y)]))
; (neighbors'-xy's 5 6)

; (defn xy-to-index [width x y]
;   (+ x (* y width)))

; (defn index-in-bounds [col indices]
;   (loop [indices indices acc []]
;     (when (seq indices)
;       (recur (rest indices)
;       (if (cons (nth col (first indices)) acc)))))
;
(defn index-in-bounds [col indices]
  (for [index indices
    :when (some? (get col index))] (get col index)))
; (index-in-bounds ["a" "b" "c"] [0 1 5])

(defn dead>alive [neighbor's-indices world]
  (let [neighbors (index-in-bounds neighbor's-indices world)]
    (if (> (apply + neighbors)
     (count neighbors)) 1 0)))

; (dead>alive [0 8 9 10] [1 0 1 0 1 0])

; (defn new-world [old-world width height]
;  (for [state old-world
;        cell (cartesian-product (range width) (range height))]
;  (let [xy-to-index (fn [x y] (+ x (* y width)))]
;    (dead>alive
;      (map #(apply xy-to-index %) (apply neighbors'-xy's cell)) old-world))))
;
; (let [xy-to-index (fn [x y] (+ x (* y 10)))]
; (dead>alive (map #(apply xy-to-index %)
; (apply neighbors'-xy's [5 7])) [0 1 1, 1 1 0, 0 0 0]))

(defn new-world [old-world width height]
(for [state old-world cell
  (cartesian-product (range width) (range height))]
   [state cell]))

(new-world (0 1 1, 1 1 0, 0 0 0) 3 3)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [width (int-input "width?")
        height (int-input "height?")]
        (let [size (* width height)]
        (new-world
           (random-world size)
           width height))))
