(in-ns pillarcon-lightning-talk.core)

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
    
    (apply-by (nome (+ 88 beat)) melody nome [])))
