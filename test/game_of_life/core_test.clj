(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))


; (print-grid (new-world #(neighbors'-indices 9 %)
;                                      [1 1 1 1 0 0 0 0 0
;                                       1 0 1 0 0 0 0 0 0
;                                       0 0 0 0 0 0 0 0 0
;                                       1 1 1 1 1 1 1 1 1
;                                       1 1 1 0 0 0 0 0 0
;                                       1 1 1 1 0 1 0 0 0
;                                       1 1 1 1 0 0 0 1 0] (range 63)) 9)
;
; (print-grid (new-world #(neighbors'-indices 9 %)
;                                      '(1 1 1 1 0 0 0 0 0
;                                       1 0 1 0 0 0 0 0 0
;                                       0 0 0 0 0 0 0 0 0
;                                       1 1 1 1 1 1 1 1 1
;                                       1 1 1 0 0 0 0 0 0
;                                       1 1 1 1 0 1 0 0 0
;                                       1 1 1 1 0 0 0 1 0) (range 63)) 9)
; (print-grid (new-world #(neighbors'-indices 9 %)
;   (random-world 63) (range 63)) 9)
;
; (random-world 63)

; (random-world 9)
; (str->int "778\n")
; (indices-in-bounds [0 0 0 0 0 0 0 0 0] (neighbors'-indices 3 7))
; (indices-in-bounds [0 1 2 3 4 5] [-1 0 1 9 10])
; (dead>alive (neighbors'-indices 3 7) [0 0 0 0 1 1 1 1 1])
; (dead>alive (neighbors'-indices 3 5) [1 1 0 0 0 0 0 0 0])
; (neighbors'-indices 3 5)
; (print-grid [0 1 2 3 4 5 6 7 8 ] 3)
