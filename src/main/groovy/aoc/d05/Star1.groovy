package aoc.d05

class Star1 {
    private Helper helper = new Helper()
    
    int apply(String input) {
        Set<String> p = helper.createPolymers()
        boolean isDone = false
        StringBuilder tmp = new StringBuilder().append(input)
        
        while (!isDone) {
            int l = tmp.size()
            for (int j = 0; j < tmp.size()-1; j++) {
                String pol = tmp.substring(j, j+2)
                if (p.contains(pol)) {
                    tmp.replace(j, j+2, "")
                }
            }
            isDone = tmp.size() == l
        }
        
        return tmp.size()
    }
}
