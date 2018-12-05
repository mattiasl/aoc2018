package aoc.d01

class Star1 {
    def apply(String input) {
        return input.split(", ").collect {"${it}" as Integer}.inject(0) {r, i -> r + i}
    }
}
