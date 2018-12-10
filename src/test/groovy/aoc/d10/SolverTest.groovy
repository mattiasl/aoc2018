package aoc.d10

import spock.lang.Shared
import spock.lang.Specification

class SolverTest extends Specification {
    @Shared implementation = new Solver()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d10/test_data.txt').text
        expect:
            implementation.apply(input) == 3
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d10/data.txt').text
        expect:
            implementation.apply(input) == 10515
    }
}
