package aoc.d03

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared implementation = new Star1()
    @Shared helper = new Helper()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d03/test_data.txt').text
        expect:
            implementation.getOverlappingInches(input, helper) == 4
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d03/data.txt').text
        expect:
            implementation.getOverlappingInches(input, helper) == 96569
    }
}