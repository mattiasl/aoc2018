package aoc.d08

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared implementation = new aoc.d08.Solver()
    @Shared summarizer = new Star2Summarizer()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d08/test_data.txt').text
        expect:
            implementation.apply(input, summarizer) == 66
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d08/data.txt').text
        expect:
            implementation.apply(input, summarizer) == 30063
    }
}
