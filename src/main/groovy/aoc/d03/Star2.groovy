package aoc.d03

class Star2 {
    Helper.Row getNonOverlappingId(String input, Helper helper) {
        List<Helper.Row> rows = helper.createRows(input)
        int[][] matrix = helper.makeFabricMatrix(rows)
        return rows.find { isOverlapOrEmpty(matrix, it) }
    }
    
    boolean isOverlapOrEmpty(int[][] f, Helper.Row r) {
        boolean answer = true
        outer:
        for (int y = r.s.y; y < r.e.y; y++) {
            for (int x = r.s.x; x < r.e.x; x++) {
                if (f[x][y] != 1) {
                    answer = false
                    break outer
                }
            }
        }
        return answer
    }
}
