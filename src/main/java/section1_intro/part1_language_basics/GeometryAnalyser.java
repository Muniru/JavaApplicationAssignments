package section1_intro.part1_language_basics;

import java.util.Arrays;

public class GeometryAnalyser {
    public static void main(String[] args) {
        //YOUR CODE HERE

        Point pointOne = PointMaker(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Point pointTwo = PointMaker(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        String operation = args[4];

        switch (operation) {
            case "dist":
                System.out.println(pointOne.euclideanDistanceTo(pointTwo));
                break;
            case "surf":
                int xLength = Math.abs(pointOne.x - pointTwo.x);
                int yLength = Math.abs(pointOne.y - pointTwo.y);
                int surface = xLength * yLength;
                System.out.println(surface);
                break;
        }

    }
    private static Point PointMaker(int x, int y) {
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
    }
}
