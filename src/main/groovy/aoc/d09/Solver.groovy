package aoc.d09

class Solver {
    long apply(int elfs, int marbles) {
        long[] score = new long[elfs]
        for (int i = 0; i < elfs; i++) {
            score[i] = 0L
        }
        
        Circle circle = createInitialCircle()
        int elf = 0
        
        for (long marble = 1L; marble <= marbles; marble++) {
            elf = (elf + 1) % elfs
            
            if (isScoringMarble(marble)) {
                score[elf] += (marble + circle.remove(-7).v)
            } else {
                circle.add(new Marble(marble), 2)
            }
            
            if (marble % Math.round(marbles/10) == 0) {
                println Math.round(100*marble/marbles) + "%"
            }
        }
        
        return Arrays.stream(score).max().getAsLong()
    }
    
    Circle createInitialCircle() {
        Circle circle = new Circle()
        Marble first = new Marble(0L)
        first.n = first
        first.p = first
        circle.add(first)
        return circle 
    }
    
    boolean isScoringMarble(long marble) {
        return marble % 23 == 0
    }
    
    static class Circle {
        Marble current
        
        void add(Marble marble, int delta = 0) {
            if (delta != 0) {
                Marble insertPosition = move(delta)
                insertPosition.p.n = marble
                marble.p = insertPosition.p
                marble.n = insertPosition
                insertPosition.p = marble
            } 
            current = marble
        }
        
        Marble remove(int delta) {
            move(delta)
            Marble removed = current
            Marble previous = removed.p
            Marble next = removed.n
            next.p = previous
            previous.n = next
            current = next
            return removed
        }
        
        private Marble move(int delta) {
            int moves = Math.abs(delta)
            for (int i = 0; i < moves; i++) {
                current = delta < 0 ? current.p : current.n
            }
            return current
        }
    }
    
    static class Marble {
        long v
        Marble p
        Marble n

        Marble(long v) {
            this.v = v
        }
    }
}
