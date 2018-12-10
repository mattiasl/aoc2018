package aoc.d07

import java.util.concurrent.ConcurrentSkipListMap
import java.util.concurrent.atomic.AtomicInteger

class Star2 {
    int apply(String input, int n, int delay) {
        Helper helper = new Helper()
        Map<String, Set<String>> steps = helper.createSetFromInput(input)
        Map<String, Integer> delays = getCustomDelay(delay)
        Map<String, AtomicInteger> workers = new ConcurrentSkipListMap<>()
        Set<String> done = new LinkedHashSet<>()
        int counter = 0
        while (done.size() != steps.size()) {
            for (Iterator<String> i = steps.keySet().iterator(); i.hasNext();) {
                String current = i.next()
                if (!workers.containsKey(current) && helper.isReadyForProcessing(current, steps, done)) {
                    addWork(current, workers, n, delays.get(current))
                }
            }
            updateWorkers(workers, done)
            counter++
        }
        println done.join()
        return counter
    }
    
    void updateWorkers(Map<String, AtomicInteger> workers, Set<String> done) {
        for (Iterator<String> i = workers.keySet().iterator(); i.hasNext(); ) {
            String key = i.next()
            if (workers.get(key).decrementAndGet() == 0) {
                done.add(key)
                workers.remove(key)
            }
        }
    }
    
    void addWork(String current, Map<String, AtomicInteger> workers, int maxWorkers, int time) {
        if (workers.size() < maxWorkers) {
            workers.put(current, new AtomicInteger(time))
        }
    }
    
    Map<String, Integer> getCustomDelay(int delay) {
        Map<String, Integer> answer = new HashMap<>()
        char offset = 'A'
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + (int) offset).intValue()
            answer.put(Character.toString(c), i + 1 + delay)
        }
        return answer
    }
}