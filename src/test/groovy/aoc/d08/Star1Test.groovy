package aoc.d08

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared implementation = new Solver()
    @Shared summarizer = new Star1Summarizer()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d08/test_data.txt').text
        expect:
            implementation.apply(input, summarizer) == 138
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d08/data.txt').text
        expect:
            implementation.apply(input, summarizer) == 48443
    }
}
