package aoc.d05

class Helper {
    private final char o = 'a'
    Set<String> createPolymers() {
        Set<String> answer = new HashSet<>()
        for (int i = 0; i < 26; i++) {
            String polymer = createPolymer(i)
            answer.add(polymer)
            answer.add(polymer.reverse())
        }
        return answer
    }
    
    String createPolymer(int i) {
        char u = (char)(i + (int) o).intValue()
        char U = Character.toUpperCase(u)
        return new StringBuilder().append(u).append(U).toString()
    }
}
