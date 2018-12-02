package aoc.p02

class Star1 {
    def checksum(def input) {
        def checksums = [:]
        input.split("\n").each {
            removeDuplicates(createIndexByLetterNumbersForId("${it}").findAll {it.value == 2 || it.value == 3}).each {
                checksums.put(it, checksums.getOrDefault(it, 0) + 1)
            }
        }
        return checksums[2] * checksums[3]
    }
    
    def removeDuplicates(Map candidates) {
        Set answer = []
        candidates.each {
            answer.add(it.value)
        }
        return answer
    }
    
    def createIndexByLetterNumbersForId(String id) {
        def answer = [:]
        id.toCharArray().each {
            answer.put(it, 1 + answer.getOrDefault(it, 0))
        }
        return answer
    }
}
