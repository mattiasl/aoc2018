package aoc.d08
import aoc.d08.Solver.Node

class Star1Summarizer implements Summarizer {
    int getSum(Node n) {
        int answer = n.metadata.sum()
        for (Node node : n.children) {
            answer += getSum(node)
        }
        return answer
    }
}
