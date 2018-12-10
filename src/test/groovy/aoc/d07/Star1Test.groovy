package aoc.d07

import spock.lang.Shared
import spock.lang.Specification

class Star1Test extends Specification {
    @Shared implementation = new aoc.d07.Star1()
    
    def "sample"() {
        given:
            String input = this.getClass().getResource('/aoc/d07/test_data.txt').text
        expect:
            implementation.apply(input) == "CABDFE"
    }

    def "solution"() {
        given:
            String input = this.getClass().getResource('/aoc/d07/data.txt').text
        expect:
            implementation.apply(input) == "BGKDMJCNEQRSTUZWHYLPAFIVXO"
    }
}
