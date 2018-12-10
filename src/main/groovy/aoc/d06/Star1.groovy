package aoc.d06

class Star1 {
    int apply(String input) {
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
        calculateArea(m, points)
        
        Point max = null
        points.each {
            if (it != null && !it.isInfinite) {
                if (max == null || it.a > max.a) {
                    max = it
                }
            }
        }
        
        return max.a
    }
    
    void calculateArea(int[][] m, Point[] p) {
        for (int y = 1; y < m[0].length; y++) {
            for (int x = 1; x < m.length; x++) {
                int r = getBestDistance(x, y, p, m.length-1, m[0].length-1)
                if (r > 0 && m[x][y] == 0) {
                    m[x][y] = r
                }
                
                if (m[x][y] != 0) {
                    p[m[x][y]].addAreaUnit()
                }
            }
        }
    }
    
    int getBestDistance(int x, int y, Point[] p, int mx, int my) {
        Map<Integer, List<Point>> result = new HashMap<>()
        for (int i = 1; i < p.length; i++) {
            int d = getDistance(x, y, p[i].x, p[i].y)
            List<Point> points = result.getOrDefault(d, new ArrayList<>())
            points.add(p[i])
            result.put(d, points)
        }
        
        List<Integer> sorted = result.keySet().sort()
        Integer key = sorted.get(0)
        int answer = 0
        if (result.get(key).size() == 1) {
            answer = result.get(key).get(0).i
            if (x == 1 || y == 1 || x == mx || y == my) {
                result.get(key).get(0).setInfinite()
            }
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
        private boolean isInfinite
        private int a
        Point(int x, int y, int i) {
            this.x = x
            this.y = y
            this.i = i
            this.a = 0
            this.isInfinite = false
        }
        
        void addAreaUnit() {
            this.a++
        }
        
        int getA() {
            return this.a
        }
        
        void setInfinite() {
            this.isInfinite = true
        }
        
        String toString() {
            return i + " = " + a + ", isInfinite=" + isInfinite
        }
    }
}
