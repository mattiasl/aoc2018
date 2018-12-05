package aoc.d03

class Star1 {
    def getOverlappingInches(String input, Helper helper) {
        List<Helper.Row> rows = helper.createRows(input)
        int[][] matrix = helper.makeFabricMatrix(rows)
        Helper.Point max = helper.getMaxXAndMaxY(rows)
        int answer = 0
        for (int j = 0; j < max.y; j++) {
            for (int i = 0; i < max.x; i++) {
                if (matrix[i][j] > 1) {
                    answer++
                }
            }
        }
        return answer
    }
}