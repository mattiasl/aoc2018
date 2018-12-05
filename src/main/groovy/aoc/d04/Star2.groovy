package aoc.d04

class Star2 {
    private Helper helper = new Helper()
    
    def apply(String input) {
        Map<String, List<String>> shiftEvents = helper.createShiftEvents(input)
        Map<String, int[]> sleep = new HashMap<>()
        shiftEvents.each {
            String id = helper.getId(it.key)
            helper.addSleep(id, it.value, sleep)
        }

        String id = null
        int max = 0
        int maxId = 0
        sleep.each {
            String k = it.key
            for (int i = 0; i < 60; i++) {
                if (sleep.get(k)[i] > max) {
                    max = sleep.get(k)[i]
                    maxId = i
                    id = k
                }
            }
        }

        return (id as Integer) * maxId
    }
}