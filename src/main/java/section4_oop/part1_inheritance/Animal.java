/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section4_oop.part1_inheritance;

import java.util.*;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class Animal {

    private final String name;
    private final int age;
    protected int maxAge;
    protected double maxSpeed;
    protected MovingType movingType;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        StringBuilder format = new StringBuilder();
        if (age < 0 || age > maxAge)
            format.append("Error: maximum age of ")
                    .append(name)
                    .append(" is ")
                    .append(maxAge)
                    .append(" years. Please give new values");
        else
            format.append(isVowel(name.toCharArray()[0])?"An ":"A ")
                    .append(name)
                    .append(" of age ")
                    .append(age)
                    .append(" moving in ")
                    .append(movingType.toString().toLowerCase())
                    .append(" at ")
                    .append(getSpeed())
                    .append(" km/h");
        return format.toString();
    }

    /**
     * returns the name of the animal
     * @return name the species name
     */
    public String getName() {
        //YOUR CODE HERE (and remove the throw statement)
        return name;
    }
    
    /**
     * returns the movement type
     * @return movementType the way the animal moves
     */
    public String getMovementType() {
        //YOUR CODE HERE (and remove the throw statement)
       return this.movingType.toString().toLowerCase();
    }
    
    /**
     * returns the speed of this animal
     * @return speed the speed of this animal
     */
    public double getSpeed() {
        //YOUR CODE HERE (and remove the throw statement)
        return round(maxSpeed * (0.5 + (0.5 * ((double) (maxAge - age) / maxAge))), 1);
    }

    // Stack Overflow hihi
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
    private boolean isVowel(char letter){
        List<Character> vowels = new ArrayList<Character>(){
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }
        };
        return vowels.contains(letter);
    }
    
}

