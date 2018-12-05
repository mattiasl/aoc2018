package aoc.d03

class Helper {
    List<Row> createRows(String input) {
        List<Row> answer = new ArrayList<>()
        input.split("\n").each {
            answer.add(Row.map(it))
        }
        return answer
    }

    Point getMaxXAndMaxY(List<Row> rows) {
        int mx = 0
        int my = 0
        rows.each {
            Row r = it
            if (r.e.x > mx) {
                mx = r.e.x
            }
            if (r.e.y > my) {
                my = r.e.y
            }
        }
        return new Point(mx, my)
    }
    
    int[][] makeFabricMatrix(List<Row> rows) {
        Point max = getMaxXAndMaxY(rows)
        int[][] answer = new int[max.x][max.y]
        for (int j = 0; j < max.y; j++) {
            for (int i = 0; i < max.x; i++) {
                answer[i][j] = 0
            }
        }

        rows.each {
            for (int y = it.s.y; y < it.e.y; y++) {
                for (int x = it.s.x; x < it.e.x; x++) {
                    answer[x][y]++
                }
            }
        }
        
        return answer
    }

    static class Row {
        public String i
        //start coordinates
        Point s
        // end coordinates
        Point e

        /**
         * @param row - #1 @ 1,3: 4x4
         * @return provided row as Row
         */
        static Row map(String row) {
            String[] parts = row.split(" ")
            String id = parts[0].substring(1)
            String[] c = parts[2].replace(":", "").split(",")
            String[] size = parts[3].split("x")
            return new Row().with {
                i = id
                s = new Point(c[0] as Integer, c[1] as Integer)
                e = new Point((int)s.x + (size[0] as Integer), (int)s.y + (size[1] as Integer))
                it
            }
        }

        String toString() {
            return "#" + i + " @ " + s.x + "," + s.y + ": " + (e.x-s.x) + "x" + (e.y-s.y)
        }
    }
    
    static class Point {
        public final int x
        public final int y
        Point(int x, int y) {
            this.x = x
            this.y = y
        }
    }
}