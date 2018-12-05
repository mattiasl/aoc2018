package aoc.d02

import spock.lang.Shared
import spock.lang.Specification

class Star2Test extends Specification {
    @Shared implementation = new Star2()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d02/test_data2.txt').text
        expect:
            implementation.commonLetters(input) == "fgij"
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d02/data.txt').text
        expect:
            implementation.commonLetters(input) == "iosnxmfkpabcjpdywvrtahluy"
    }
}
