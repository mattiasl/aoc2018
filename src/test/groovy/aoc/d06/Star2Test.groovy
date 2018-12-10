package aoc.d06

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared implementation = new aoc.d06.Star2()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d06/test_data.txt').text
        expect:
            implementation.apply(input, 32) == 16
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d06/data.txt').text
        expect:
            implementation.apply(input, 10000) == 35294
    }
}
