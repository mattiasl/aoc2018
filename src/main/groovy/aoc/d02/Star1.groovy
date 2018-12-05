package aoc.d02

class Star1 {
    def checksum(String input) {
        Map<String, Map<String, Integer>> checksum = [:]
        input.split("\n").each {
            removeDuplicates(createIndexByLetterNumbersForId("${it}").findAll {it.value == 2 || it.value == 3}).each {
                checksum.put(it, checksum.getOrDefault(it, 0) + 1)
            }
        }
        return checksum[2] * checksum[3]
    }
    
    def removeDuplicates(Map candidates) {
        Set answer = []
        candidates.each {
            answer.add(it.value)
        }
        return answer
    }

    Map<String, Integer> createIndexByLetterNumbersForId(String id) {
        Map<String, Integer> answer = new HashMap<>()
        id.toCharArray().each {
            answer.put(it, 1 + answer.getOrDefault(it, 0))
        }
        return answer
    }
}
