package aoc.d05

class Star1 {
    int apply(String input) {
        Deque<Character> answer = new LinkedList<>()
        for (int j = 0; j < input.size();  j++) {
            char p = input.charAt(j)
            
            if (answer.size() == 0) {
                answer.addLast(p)
                continue
            }
            
            Character c = answer.peekLast()
            if (isPolymer(c.charValue(), p)) {
                answer.removeLast()
            } else {
                answer.addLast(p)
            }
        }
        
        return answer.size()
    }

    boolean isPolymer(char p1, char p2) {
        return Character.toLowerCase(p1) == Character.toLowerCase(p2) && p1 != p2
    }
}
