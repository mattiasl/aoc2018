package aoc.d01

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class Star2Test extends Specification {
    def @Shared implementation = new Star2();

    @Unroll
    def "when #input is given then #expected is expected"() {
        expect:
            implementation.apply(input) == expected
        where:
            input                | expected
            "+1, -1"             | 0
            "+3, +3, +4, -2, -4" | 10
            "-6, +3, +8, +5, -6" | 5
            "+7, +7, -2, -7, -4" | 14
    }
    
    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d01/data.txt').text
        expect:
            implementation.apply(input) == 464
    }
}
