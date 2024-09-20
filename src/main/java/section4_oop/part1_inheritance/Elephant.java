package section4_oop.part1_inheritance;

public class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
        maxAge = 86;
        maxSpeed = 40;
        movingType = MovingType.THUNDER;
    }
}
