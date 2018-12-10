package aoc.d07

class Helper {
    private String getPrecondition(String s) {
        return s.substring(5, 6)
    }

    private String getStep(String s) {
        return s.substring(36, 37)
    }

    Map<String, Set<String>> createSetFromInput(String input) {
        Map<String, Set<String>> answer = new TreeMap<>()
        input.split("\n").each {
            String s = getStep(it)
            String p = getPrecondition(it)
            answer.putIfAbsent(s, new TreeSet<String>())
            answer.get(s).add(p)
            answer.putIfAbsent(p, new TreeSet<String>())
        }
        return answer
    }
    
    boolean isReadyForProcessing(String current, Map<String, Set<String>> steps, Set<String> done) {
        return !done.contains(current) && isDependenciesDone(current, steps, done)
    }

    private boolean isDependenciesDone(String current, Map<String, Set<String>> steps, Set<String> done) {
        boolean answer = true
        for (String dependency: steps.get(current)) {
            if (!done.contains(dependency)) {
                answer = false
                break
            }
        }
        return answer
    }
}
