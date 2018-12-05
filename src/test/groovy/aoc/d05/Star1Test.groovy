package aoc.d05

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared Star1 implementation = new Star1() 
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d05/test_data.txt').text
        expect:
            implementation.apply(input) == 10
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d05/data.txt').text
        expect:
            implementation.apply(input) == 10878
    }
}
