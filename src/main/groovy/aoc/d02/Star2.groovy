package aoc.d02

class Star2 {
    def commonLetters(String input) {
        String[] ids = input.split("\n")
        String answer = null
        for (int i = 0; answer == null && i < ids.size(); i++) {
            answer = findMatch(ids[i], ids.findAll {it != ids[i]})
        }
        return answer
    }
    
    String findMatch(String candidate, List<String> ids) {
        String answer = null
        for (int i = 0; i < ids.size(); i++) {
            String matching = getMatchingChars(candidate, ids.get(i))
            if ((candidate.length() - matching.length()) == 1) {
                answer = matching
                break
            }
        }
        return answer
    }
    
    String getMatchingChars(String id1, String id2) {
        StringBuilder answer = new StringBuilder()
        for (int k = 0; k < id1.length(); k++) {
            answer.append(id1.charAt(k) == id2.charAt(k) ? id1.charAt(k) : "")
        }
        return answer.toString()
    }
}
