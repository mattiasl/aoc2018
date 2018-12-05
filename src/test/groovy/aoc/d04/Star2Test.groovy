package aoc.d04

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared implementation = new aoc.d04.Star2()

    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d04/test_data.txt').text
        expect:
            implementation.apply(input) == 4455
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d04/data.txt').text
        expect:
            implementation.apply(input) == 141071
    }
}
