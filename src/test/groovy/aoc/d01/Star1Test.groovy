package aoc.d01

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class Star1Test extends Specification {
    def @Shared implementation = new Star1()
    @Unroll
    def "when #input is given then #expected is expected"() {
        expect:
            implementation.apply(input) == expected
        where:
            input | expected
            "+1, +1, +1" | 3
            "+1, +1, -2" | 0
            "-1, -2, -3" | -6
    }
    
    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d01/data.txt').text
        expect:
            implementation.apply(input) == 529
    }
}
