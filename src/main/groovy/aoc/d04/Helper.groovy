package aoc.d04

class Helper {

    Map<String, List<String>> createShiftEvents(String input) {
        Map<String, List<String>> answer = new HashMap<>()
        String currentShiftKey = null
        List<String> result = input.split("\n").sort()
        for (int i = 0; i < result.size(); i++) {
            String it = result.get(i)
            if (it.endsWith("begins shift")) {
                currentShiftKey = it
                answer.put(currentShiftKey, [])
            } else {
                answer.get(currentShiftKey).add(it)
            }
        }
        return answer
    }
    
    void addSleep(String id, List<String> shiftEvents, Map<String, int[]> sleepMemory) {
        int[] sleep = sleepMemory.getOrDefault(id, getDefaultSleep())
        for (Iterator<String> i = shiftEvents.iterator(); i.hasNext(); ) {
            addSleep(sleep, i.next(), i.next())
        }
        sleepMemory.put(id, sleep)
    }

    void addSleep(int[] sleep, String start, String end) {
        for (int i = getMinutes(start); i < getMinutes(end); i++) {
            sleep[i]++
        }
    }

    int getMinutes(String row) {
        return row.substring(row.indexOf(":") + 1, row.indexOf("]")) as Integer
    }

    int[] getDefaultSleep() {
        int[] answer = new int[60]
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 0
        }
        return answer
    }

    String getId(String row) {
        int hash = row.indexOf("#")
        return row.substring(hash + 1, row.indexOf(" ", hash))
    }
}
