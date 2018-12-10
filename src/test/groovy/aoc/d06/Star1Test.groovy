package aoc.d06

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared implementation = new aoc.d06.Star1()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d06/test_data.txt').text
        expect:
            implementation.apply(input) == 17
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d06/data.txt').text
        expect:
            implementation.apply(input) == 5035
    }
}
