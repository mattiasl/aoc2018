package aoc.d08

import java.util.stream.Collectors

class Solver {
    int apply(String input, Summarizer summarizer) {
        return summarizer.getSum(populateNodes(parse(input).iterator()))
    }

    Node populateNodes(Iterator<Integer> it) {
        Node answer = new Node()
        int c = it.next()
        int m = it.next()
        if (c > 0) {
            for (int i = 0; i < c; i++) {
                answer.addChild(populateNodes(it))
            }
        }
        for (int i = 0; i < m; i++) {
            answer.addMetadata(it.next())
        }
        return answer
    }
    
    List<Integer> parse(String input) {
        return Arrays.stream(input.split(" ")).map({s -> s as Integer}).collect(Collectors.toList())
    }

    static class Node {
        private List<Node> children = new ArrayList<>()
        private List<Integer> metadata = new ArrayList<>()

        void addChild(Node child) {
            children.add(child)
        }

        void addMetadata(int meta) {
            metadata.add(meta)
        }
    }
}