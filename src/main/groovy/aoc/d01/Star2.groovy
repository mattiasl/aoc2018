package aoc.d01

class Star2 {
    def apply(String input) {
        def list = input.split(", ").collect {"${it}" as Integer}
        int answer = 0
        int i = 0
        for (Set memory = []; memory.add(answer); answer += list[i++ % list.size()]) {
            //no-op
        }
        return answer
    }
}
