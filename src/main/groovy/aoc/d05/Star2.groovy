package aoc.d05

class Star2 {
    int apply(String input) {
        int best = Integer.MAX_VALUE 
        for (int i = 0; i < 26; i++) {
            char letter = (char)(i + (int) 'a')
            Deque<Character> answer = new LinkedList<>()
            for (int j = 0; j < input.size();  j++) {
                char p = input.charAt(j)
                if (Character.toLowerCase(p) == letter) {
                    continue
                }
                
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
            
            best = Math.min(answer.size(), best)
        }
        return best
    }

    boolean isPolymer(char p1, char p2) {
        return Character.toLowerCase(p1) == Character.toLowerCase(p2) && p1 != p2
    }
}
