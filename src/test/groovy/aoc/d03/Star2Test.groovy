package aoc.d03

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared implementation = new Star2()
    @Shared helper = new Helper()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d03/test_data.txt').text
        expect:
            implementation.getNonOverlappingId(input, helper).i == "3"
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d03/data.txt').text
        expect:
            implementation.getNonOverlappingId(input, helper).i == "1023"
    }
}