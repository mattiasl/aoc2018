package aoc.d04

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared implementation = new aoc.d04.Star1()

    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d04/test_data.txt').text
        expect:
            implementation.apply(input) == 240
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d04/data.txt').text
        expect:
            implementation.apply(input) == 38813
    }
}
