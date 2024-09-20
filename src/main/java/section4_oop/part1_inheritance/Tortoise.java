package section4_oop.part1_inheritance;

public class Tortoise extends Animal {
    public Tortoise(String name, int age) {
        super(name, age);
        maxAge = 190;
        maxSpeed = .3;
        movingType = MovingType.CRAWL;
    }
}
