package section1_intro.part1_language_basics;


public class Point {
    int x;
    int y;

    /**
     * Create an instance of class point that is located at the same coordinates as the current object, but in the
     * diagonally opposing quadrant of coordinate space.
     * So, when the current point is at (4, 4), this method will return Point(-4, -4)
     * and when the current point is at (2, -5) it will return Point(-2, 5).
     * @return inverse Point
     */
    Point createInversePoint() {
        Point point = new Point();
        point.x = this.x * -1;
        point.y = this.y * -1;
        return point;
    }

    /**
     * This method returns the Euclidean distance of the current point (this) to the given point (otherPoint).
     * GIYF if you forgot what Euclidean distance is and how it is calculated.
     * @param otherPoint
     * @return euclidean distance
     */
    double euclideanDistanceTo(Point otherPoint) {
        //YOUR CODE HERE
        long xDistance = this.x - otherPoint.x;
        long yDistance = this.y - otherPoint.y;

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
}
