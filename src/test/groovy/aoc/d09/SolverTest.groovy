package aoc.d09

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class SolverTest extends Specification {
    @Shared implementation = new aoc.d09.Solver()
    @Unroll
    def "when #players and last marble is worth #max points then high score is #highscore"() {
        expect:
            implementation.apply(players, max) == highscore
        where:
            players | max     | highscore
            9       | 25      | 32
            10      | 1618    | 8317
            13      | 7999    | 146373
            17      | 1104    | 2764
            21      | 6111    | 54718
            30      | 5807    | 37305
            405     | 71700   | 428690
            405     | 7170000 | 3628143500
    }
}
