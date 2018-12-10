package aoc.d08
import aoc.d08.Solver.Node

class Star2Summarizer implements Summarizer {
    int getSum(Node n) {
        int answer = 0
        List<Node> children = n.children
        List<Integer> metadata = n.metadata

        if (children.size() == 0) {
            answer += metadata.sum()
        } else {
            for (Integer m : metadata) {
                if (m <= children.size()) {
                    answer += getSum(children.get(m-1))
                }
            }
        }
        return answer
    }
}
