package aoc.d06

class Star2 {
    int apply(String input, int max) {
        int mx = 0
        int my = 0
        int n = 0
        input.split("\n").each {
            String[] p = it.split(", ")
            int x = Integer.parseInt(p[0])
            int y = Integer.parseInt(p[1])
            if (x > mx) {
                mx = x+1
            }
            if (y > my) {
                my = y+1
            }
            n++
        }
        n++
        
        int[][] m = new int[mx][my]
        for (int y = 0; y < my; y++) {
            for (int x = 0; x < mx; x++) {
                m[x][y] = 0
            }
        }
        int i = 0
        
        Point[] points = new Point[n]
        
        input.split("\n").each {
            String[] p = it.split(", ")
            int x = Integer.parseInt(p[0])
            int y = Integer.parseInt(p[1])
            m[x][y] = ++i
            points[i] = new Point(x, y , i)
        }
        return find(m, points, max)
    }
    
    int find(int[][] m, Point[] p, int max) {
        int sum = 0
        for (int y = 1; y < m[0].length; y++) {
            for (int x = 1; x < m.length; x++) {
                int r = getDistanceSum(x, y, p)
                m[x][y] = r
                if (r < max) {
                    sum++
                }
            }
        }
        
        return sum
    }
    
    int getDistanceSum(int x, int y, Point[] p) {
        int answer = 0
        
        for (int i = 1; i < p.length; i++) {
            answer += getDistance(x, y, p[i].x, p[i].y)
        }
        
        return answer
    }

    int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2)
    }
    
    
    static class Point {
        public final int x
        public final int y
        public final int i
        Point(int x, int y, int i) {
            this.x = x
            this.y = y
            this.i = i
        }
    }
}
