package aoc.p02

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared Star1 implementation = new Star1() 
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/p02/test_data1.txt').text
        expect:
            implementation.checksum(input) == 12
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/p02/data.txt').text
        expect:
            implementation.checksum(input) == 8610
    }

}
