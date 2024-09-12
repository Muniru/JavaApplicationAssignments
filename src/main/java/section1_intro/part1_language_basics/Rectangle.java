package section1_intro.part1_language_basics;

public class Rectangle {
    Point upperLeft;
    Point lowerRight;

    /**
     * This method returns the surface defined by the rectangle with the given Point objects at the upper left and
     * lower right corners.
     * The method assumes two corners have been set already (and are not null).
     * @return surface
     */
    int getSurface(){
        //calculate surface - can you implement this?
        int xLength = Math.abs(upperLeft.x - lowerRight.x);
        int yLength = Math.abs(upperLeft.y - lowerRight.y);

        return xLength * yLength;
    }
}
