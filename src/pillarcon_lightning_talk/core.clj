(ns pillarcon-lightning-talk.core
  (:use [overtone.live]
        [overtone.inst.piano]))

;; lets make noise
(definst sine-wave [frequency 440] (sin-osc frequency))
(sine-wave)

;; lets stop making noise
(stop)

;; making notes
(definst boop [frequency 440 duration 1]
  (let [envelope (line 1 0 duration :action FREE)]
          (* envelope (sin-osc frequency))))
(boop)
(boop :duration 1/2)


;; a more complicated synth
(definst bell [frequency 440 duration 10
               h0 1 h1 0.6 h2 0.4 h3 0.25 h4 0.2 h5 0.15]
  (let [harmonic-series [ 1  2  3  4  5  6]
                        ;[ 1  2  3  4.2 5.4 6.8]
        proportions     [h0 h1 h2 h3 h4 h5]
        component
         (fn [harmonic proportion]
           (* 1/2
              proportion
              (env-gen (perc 0.01 (* proportion duration)))
              (sin-osc (* harmonic frequency))))
        whole
          (mix (map component harmonic-series proportions))]
    (detect-silence whole :action FREE)
    whole))

(bell 300)


;(use 'overtone.inst.piano)
(piano 69)

;;midi
(piano (note :c4))
(piano (note :e4))
(piano (note :g4))

;; scales

(play-even (range 69 81))

(play-even (scale :c4 :major))
(play-even (scale :c4 :minor))
(play-even (scale :c4 :hirajoshi))

;; chords
(play-chord (chord :a4 :major)) 

(play-chord (chord :a4 :sus2))
(play-chord (chord :g4 :sus2))
(play-chord (chord :f4 :sus2))

(play-chord (chord :g4 :m7+5-9))





; scheduling notes
; the lazy way
(comment
(defn play-even [note-seq]
    (doseq [note note-seq]
          (piano note)
                (Thread/sleep 250)))
)




; metronome
(let [time (now)]
  (at time (play-chord (chord :g3 :major)))
  (at (+ 2000 time) (play-chord (chord :c3 :major)))
  (at (+ 3000 time) (play-chord (chord :d3 :major)))
  (at (+ 4300 time) (play-chord (chord :g3 :major))))


(defn melody [nome]
  (let [beat (nome)]
    ;; Intro
    (at (nome beat) (piano (note :F#4)))
    (at (nome beat) (piano (note :E5)))
    (at (nome (+ 1 beat)) (piano (note :F#4)))
    (at (nome (+ 1 beat)) (piano (note :E5)))
    (at (nome (+ 3 beat)) (piano (note :F#4)))
    (at (nome (+ 3 beat)) (piano (note :E5)))
    (at (nome (+ 5 beat)) (piano (note :F#4)))
    (at (nome (+ 5 beat)) (piano (note :C5)))
    (at (nome (+ 6 beat)) (piano (note :F#4)))
    (at (nome (+ 6 beat)) (piano (note :E5)))
    (at (nome (+ 8 beat)) (piano (note :G4)))
    (at (nome (+ 8 beat)) (piano (note :B4)))
    (at (nome (+ 8 beat)) (piano (note :G5)))
    (at (nome (+ 12 beat)) (piano (note :G4)))
    ;; A
    (at (nome (+ 16 beat)) (piano (note :C5)))
    (at (nome (+ 16 beat)) (piano (note :E4)))
    (at (nome (+ 19 beat)) (piano (note :G4)))
    (at (nome (+ 19 beat)) (piano (note :C4)))
    (at (nome (+ 22 beat)) (piano (note :E4)))
    (at (nome (+ 22 beat)) (piano (note :G3)))
   
    (at (nome (+ 25 beat)) (piano (note :A4)))
    (at (nome (+ 25 beat)) (piano (note :C4)))
    (at (nome (+ 27 beat)) (piano (note :B4)))
    (at (nome (+ 27 beat)) (piano (note :D4)))
    (at (nome (+ 29 beat)) (piano (note :Bb4)))
    (at (nome (+ 29 beat)) (piano (note :Db4)))
    (at (nome (+ 30 beat)) (piano (note :A4)))
    (at (nome (+ 30 beat)) (piano (note :C4)))
   
    (at (nome (+ 32 beat)) (piano (note :G4)))
    (at (nome (+ 32 beat)) (piano (note :C4)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 2) (piano (note :E5)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 2) (piano (note :G4)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 3) (piano (note :G5)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 3) (piano (note :D5)))
    (at (nome (+ 36 beat)) (piano (note :A5)))
    (at (nome (+ 36 beat)) (piano (note :C5)))
    (at (nome (+ 38 beat)) (piano (note :F5)))
    (at (nome (+ 38 beat)) (piano (note :A4)))
    (at (nome (+ 39 beat)) (piano (note :G5)))
    (at (nome (+ 39 beat)) (piano (note :B4)))

    (at (nome (+ 41 beat)) (piano (note :E5)))
    (at (nome (+ 41 beat)) (piano (note :A4)))
    (at (nome (+ 43 beat)) (piano (note :C5)))
    (at (nome (+ 43 beat)) (piano (note :E4)))

    (at (nome (+ 44 beat)) (piano (note :D5)))
    (at (nome (+ 44 beat)) (piano (note :F4)))
    (at (nome (+ 45 beat)) (piano (note :B4)))
    (at (nome (+ 45 beat)) (piano (note :D4)))

    (at (nome (+ 48 beat)) (piano (note :C5)))
    (at (nome (+ 48 beat)) (piano (note :E4)))
    (at (nome (+ 51 beat)) (piano (note :G4)))
    (at (nome (+ 51 beat)) (piano (note :C4)))
    (at (nome (+ 54 beat)) (piano (note :E4)))
    (at (nome (+ 54 beat)) (piano (note :G3)))
   
    (at (nome (+ 57 beat)) (piano (note :A4)))
    (at (nome (+ 57 beat)) (piano (note :C4)))
    (at (nome (+ 59 beat)) (piano (note :B4)))
    (at (nome (+ 59 beat)) (piano (note :D4)))
    (at (nome (+ 61 beat)) (piano (note :Bb4)))
    (at (nome (+ 61 beat)) (piano (note :Db4)))
    (at (nome (+ 62 beat)) (piano (note :A4)))
    (at (nome (+ 62 beat)) (piano (note :C4)))
   
    (at (nome (+ 64 beat)) (piano (note :G4)))
    (at (nome (+ 64 beat)) (piano (note :C4)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 2) (piano (note :E5)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 2) (piano (note :G4)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 3) (piano (note :G5)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 3) (piano (note :D5)))
    (at (nome (+ 68 beat)) (piano (note :A5)))
    (at (nome (+ 68 beat)) (piano (note :C5)))
    (at (nome (+ 70 beat)) (piano (note :F5)))
    (at (nome (+ 70 beat)) (piano (note :A4)))
    (at (nome (+ 71 beat)) (piano (note :G5)))
    (at (nome (+ 71 beat)) (piano (note :B4)))

    (at (nome (+ 73 beat)) (piano (note :E5)))
    (at (nome (+ 73 beat)) (piano (note :A4)))
    (at (nome (+ 75 beat)) (piano (note :C5)))
    (at (nome (+ 75 beat)) (piano (note :E4)))
    (at (nome (+ 76 beat)) (piano (note :D5)))
    (at (nome (+ 76 beat)) (piano (note :F4)))
    (at (nome (+ 77 beat)) (piano (note :B4)))
    (at (nome (+ 77 beat)) (piano (note :D4)))
    
    (apply-by (nome (+ 88 beat)) melody nome [])))

(def met (metronome (* 200 2)))

(melody met)












































(defn triplet
    "subdivide two time intervals by 3, and return the time interval
    at position. "
    [a b position]
    (+ a (* position (/ (- b a) 3) )))

(defn play-even [note-seq]
  (doseq [note note-seq]
    (piano note)
      (Thread/sleep 250)))

(defn play-chord [a-chord]
  (doseq [note a-chord] (piano note)))

(defn minor-melody [nome]
  (let [beat (nome)]
    ;; Intro
    (at (nome beat) (piano (note :F#4)))
    (at (nome beat) (piano (note :Eb5)))
    (at (nome (+ 1 beat)) (piano (note :F#4)))
    (at (nome (+ 1 beat)) (piano (note :Eb5)))
    (at (nome (+ 3 beat)) (piano (note :F#4)))
    (at (nome (+ 3 beat)) (piano (note :Eb5)))
    (at (nome (+ 5 beat)) (piano (note :F#4)))
    (at (nome (+ 5 beat)) (piano (note :C5)))
    (at (nome (+ 6 beat)) (piano (note :F#4)))
    (at (nome (+ 6 beat)) (piano (note :Eb5)))
    (at (nome (+ 8 beat)) (piano (note :G4)))
    (at (nome (+ 8 beat)) (piano (note :B4)))
    (at (nome (+ 8 beat)) (piano (note :G5)))
    (at (nome (+ 12 beat)) (piano (note :G4)))
    ;; A
    (at (nome (+ 16 beat)) (piano (note :C5)))
    (at (nome (+ 16 beat)) (piano (note :Eb4)))
    (at (nome (+ 19 beat)) (piano (note :G4)))
    (at (nome (+ 19 beat)) (piano (note :C4)))
    (at (nome (+ 22 beat)) (piano (note :Eb4)))
    (at (nome (+ 22 beat)) (piano (note :G3)))
   
    (at (nome (+ 25 beat)) (piano (note :A4)))
    (at (nome (+ 25 beat)) (piano (note :C4)))
    (at (nome (+ 27 beat)) (piano (note :B4)))
    (at (nome (+ 27 beat)) (piano (note :D4)))
    (at (nome (+ 29 beat)) (piano (note :Bb4)))
    (at (nome (+ 29 beat)) (piano (note :Db4)))
    (at (nome (+ 30 beat)) (piano (note :A4)))
    (at (nome (+ 30 beat)) (piano (note :C4)))
   
    (at (nome (+ 32 beat)) (piano (note :G4)))
    (at (nome (+ 32 beat)) (piano (note :C4)))
    ;(at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 1) (piano (note :G4)))
    ;(at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 1) (piano (note :C4)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 2) (piano (note :Eb5)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 2) (piano (note :G4)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 3) (piano (note :G5)))
    (at (triplet (nome (+ 32 beat)) (nome (+ 35 beat)) 3) (piano (note :D5)))
    (at (nome (+ 36 beat)) (piano (note :A5)))
    (at (nome (+ 36 beat)) (piano (note :C5)))
    (at (nome (+ 38 beat)) (piano (note :F5)))
    (at (nome (+ 38 beat)) (piano (note :A4)))
    (at (nome (+ 39 beat)) (piano (note :G5)))
    (at (nome (+ 39 beat)) (piano (note :B4)))

    (at (nome (+ 41 beat)) (piano (note :Eb5)))
    (at (nome (+ 41 beat)) (piano (note :A4)))
    (at (nome (+ 43 beat)) (piano (note :C5)))
    (at (nome (+ 43 beat)) (piano (note :Eb4)))
    (at (nome (+ 44 beat)) (piano (note :D5)))
    (at (nome (+ 44 beat)) (piano (note :F4)))
    (at (nome (+ 45 beat)) (piano (note :B4)))
    (at (nome (+ 45 beat)) (piano (note :D4)))

    (at (nome (+ 48 beat)) (piano (note :C5)))
    (at (nome (+ 48 beat)) (piano (note :Eb4)))
    (at (nome (+ 51 beat)) (piano (note :G4)))
    (at (nome (+ 51 beat)) (piano (note :C4)))
    (at (nome (+ 54 beat)) (piano (note :Eb4)))
    (at (nome (+ 54 beat)) (piano (note :G3)))
   
    (at (nome (+ 57 beat)) (piano (note :A4)))
    (at (nome (+ 57 beat)) (piano (note :C4)))
    (at (nome (+ 59 beat)) (piano (note :B4)))
    (at (nome (+ 59 beat)) (piano (note :D4)))
    (at (nome (+ 61 beat)) (piano (note :Bb4)))
    (at (nome (+ 61 beat)) (piano (note :Db4)))
    (at (nome (+ 62 beat)) (piano (note :A4)))
    (at (nome (+ 62 beat)) (piano (note :C4)))
   
    (at (nome (+ 64 beat)) (piano (note :G4)))
    (at (nome (+ 64 beat)) (piano (note :C4)))
    ;(at (triplet (nome (+ 64 beat)) (nome (+ 35 beat)) 1) (piano (note :G4)))
    ;(at (triplet (nome (+ 64 beat)) (nome (+ 35 beat)) 1) (piano (note :C4)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 2) (piano (note :Eb5)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 2) (piano (note :G4)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 3) (piano (note :G5)))
    (at (triplet (nome (+ 64 beat)) (nome (+ 67 beat)) 3) (piano (note :D5)))
    (at (nome (+ 68 beat)) (piano (note :A5)))
    (at (nome (+ 68 beat)) (piano (note :C5)))
    (at (nome (+ 70 beat)) (piano (note :F5)))
    (at (nome (+ 70 beat)) (piano (note :A4)))
    (at (nome (+ 71 beat)) (piano (note :G5)))
    (at (nome (+ 71 beat)) (piano (note :B4)))

    (at (nome (+ 73 beat)) (piano (note :Eb5)))
    (at (nome (+ 73 beat)) (piano (note :A4)))
    (at (nome (+ 75 beat)) (piano (note :C5)))
    (at (nome (+ 75 beat)) (piano (note :Eb4)))
    (at (nome (+ 76 beat)) (piano (note :D5)))
    (at (nome (+ 76 beat)) (piano (note :F4)))
    (at (nome (+ 77 beat)) (piano (note :B4)))
    (at (nome (+ 77 beat)) (piano (note :D4)))
    
    (apply-by (nome (+ 88 beat)) minor-melody nome [])))
