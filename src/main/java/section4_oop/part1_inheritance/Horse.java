package section4_oop.part1_inheritance;

public class Horse extends Animal {
    public Horse(String name, int age) {
        super(name, age);
        maxAge = 62;
        maxSpeed = 88;
        movingType = MovingType.GALLOP;
    }
}
