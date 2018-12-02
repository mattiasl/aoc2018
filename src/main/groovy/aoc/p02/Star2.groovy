package aoc.p02

class Star2 {
    def commonLetters(def input) {
        def ids = input.split("\n")
        def answer = null
        for (int i = 0; answer == null && i < ids.size(); i++) {
            answer = findMatch(ids[i], ids.findAll {it != ids[i]})
        }
        return answer
    }
    
    def findMatch(String candidate, def ids) {
        for (int i = 0; i < ids.size(); i++) {
            def matching = getMatchingChars(candidate, ids[i])
            if (candidate.length() - matching.length() == 1) {
                return matching
            }
        }
        return null
    }
    
    def getMatchingChars(def id1, def id2) {
        StringBuilder answer = new StringBuilder()
        for (int k = 0; k < id1.length(); k++) {
            answer.append(id1.charAt(k) == id2.charAt(k) ? id1.charAt(k) : "")
        }
        return answer.toString()
    }
}
