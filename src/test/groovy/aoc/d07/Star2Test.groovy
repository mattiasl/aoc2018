package aoc.d07

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared implementation = new aoc.d07.Star2()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d07/test_data.txt').text
        expect:
            implementation.apply(input, 2, 0) == 15
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d07/data.txt').text
        expect:
            implementation.apply(input, 5, 60) == 941
    }
}
