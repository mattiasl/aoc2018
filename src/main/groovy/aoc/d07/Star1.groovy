package aoc.d07

class Star1 {
    String apply(String input) {
        Helper helper = new Helper()
        Map<String, Set<String>> steps = helper.createSetFromInput(input)
        Set<String> done = new LinkedHashSet<>()
        while (done.size() != steps.size()) {
            for (Iterator<String> i = steps.keySet().iterator(); i.hasNext();) {
                String current = i.next()
                if (helper.isReadyForProcessing(current, steps, done)) {
                    done.add(current)
                    break
                }
            }
        }
        return done.join()
    }
}
