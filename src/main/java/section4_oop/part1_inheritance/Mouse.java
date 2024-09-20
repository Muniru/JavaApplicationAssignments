package section4_oop.part1_inheritance;

public class Mouse extends Animal {

    public Mouse(String name, int age) {
        super(name, age);
        maxAge = 13;
        maxSpeed = 21;
        movingType = MovingType.SCURRY;
    }
}
