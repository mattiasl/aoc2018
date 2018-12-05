package aoc.d05

import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class Star2 {
    private Helper helper = new Helper()
    
    int apply(String input) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        Set<String> p = helper.createPolymers()
        List<Future<Integer>> list = new ArrayList<Future<Integer>>()
        for (int i = 0; i < 26; i++) {
            list.add(executor.submit(new Worker(helper.createPolymer(i), input, p)))
        }
        
        int best = Integer.MAX_VALUE

        for(Future<String> f: list){
            try {
                if (f.get() < best) {
                    best = f.get()
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown()
        return best
    }
    
    static class Worker implements Callable<Integer> {
        private final Set<String> p
        private final String polymer
        private final String input
        Worker(String polymer, String input, Set<String> p) {
            this.p = p
            this.polymer = polymer
            this.input = input
        }
        @Override
        Integer call() throws Exception {
            boolean isDone = false
            StringBuilder tmp = new StringBuilder().append(input.replaceAll("[" + polymer + "]", ""))

            while (!isDone) {
                int l = tmp.size()
                for (int j = 0; j < tmp.size()-1; j++) {
                    if (p.contains(tmp.substring(j, j+2))) {
                        tmp.replace(j, j+2, "")
                    }
                }
                isDone = tmp.size() == l
            }

            return tmp.size()
        }
    }
}
