package aoc.d04

class Star1 {
    private Helper helper = new Helper()
    
    def apply(String input) {
        Map<String, Map<String, int[]>> sleep = new HashMap<>()
        Map<String, List<String>> shiftEvents = helper.createShiftEvents(input)
        shiftEvents.each {
            helper.addSleep(helper.getId(it.key), it.value, sleep)
        }
        
        int mostTotalSleep = 0
        String id = null
        
        sleep.each {
            int totalSleep = it.value.sum()
            if (totalSleep > mostTotalSleep) {
                mostTotalSleep = totalSleep
                id = it.key
            }
        }

        int max = 0
        int maxId = 0
        for (int i = 0; i < 60; i++) {
            if (sleep.get(id)[i] > max) {
                max = sleep.get(id)[i]
                maxId = i
            }
        }
        
        return (id as Integer) * maxId
    }
}
