package aoc.d05

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared Star2 implementation = new Star2() 
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d05/test_data.txt').text
        expect:
            implementation.apply(input) == 4
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d05/data.txt').text
        expect:
            implementation.apply(input) == 6874
    }
}
