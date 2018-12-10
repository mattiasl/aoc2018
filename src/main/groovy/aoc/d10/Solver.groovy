package aoc.d10

class Solver {
    int apply(String input) {
        List<Point> points = new ArrayList<>()
        input.split("\n").each {
            points.add(new Point(it))
        }
        FindMessageTimeResult answer = findMessageTime(points)
        printMessage(points, answer.min, answer.max)
        return answer.seconds
    }

    FindMessageTimeResult findMessageTime(List<Point> points) {
        long area = Long.MAX_VALUE
        FindMessageTimeResult answer = new FindMessageTimeResult()
        for (int j = 0; ; j++) {
            java.awt.Point max = new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)
            java.awt.Point min = new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)
            for (Iterator<Point> i = points.iterator(); i.hasNext();) {
                Point p = i.next()
                forward(p)
                updateMinAndMax(p, min, max) 
            }

            long currentArea = calculateArea(min, max)
            if (area > currentArea) {
                area = currentArea
                answer.min = min
                answer.max = max
            } else {
                for (Iterator<Point> i = points.iterator(); i.hasNext();) {
                    backward(i.next())
                }
                answer.seconds = j
                break
            }
        }
        return answer
    }
    
    long calculateArea(java.awt.Point min, java.awt.Point max) {
        return (Math.abs((long)max.@x - (long)min.@x) * Math.abs((long)max.@y - (long)min.@y))
    }
    
    void printMessage(List<Point> points, java.awt.Point min, java.awt.Point max) {
        boolean[][] r = new boolean[1 + max.x - min.x][1 + max.y - min.y]
        for (int point = 0; point < points.size(); point++) {
            Point p = points.get(point)
            r[max.@x-p.p.@x][max.@y-p.p.@y] = true 
        }
        for (int y = (max.@y - min.@y); y >= 0; y--) {
            for (int x = (max.@x - min.@x); x >= 0; x--) {
                print r[x][y] ? "#" : " "
            }
            println ""
        }
    }
    
    void updateMinAndMax(Point p, java.awt.Point min, java.awt.Point max) {
        if (p.p.@x > max.@x) {
            max.x = p.p.@x
        }
        if (p.p.@y > max.@y) {
            max.y = p.p.@y
        }

        if (p.p.@x < min.@x) {
            min.x = p.p.@x
        }
        if (p.p.@y < min.@y) {
            min.y = p.p.@y
        }
    }
    
    void forward(Point point) {
        point.p.x += point.v.x
        point.p.y += point.v.y
    }

    void backward(Point point) {
        point.p.x -= point.v.x
        point.p.y -= point.v.y
    }
    
    static class FindMessageTimeResult {
        int seconds
        java.awt.Point min
        java.awt.Point max
    }
    
    static class Point {
        final java.awt.Point p
        final java.awt.Point v
        
        Point(String raw) {
            String[] parts = raw.replace("position=", "").replace("velocity=", "").replace("> <", ";").replace("<", "").replace(">", "").split(";")
            p = getPoint(parts[0])
            v = getPoint(parts[1])
        }
        
        java.awt.Point getPoint(String part) {
            String[] parts = part.replaceAll(" ", "").split(",")
            return new java.awt.Point(parts[0] as Integer, parts[1] as Integer)
        } 
    }
}