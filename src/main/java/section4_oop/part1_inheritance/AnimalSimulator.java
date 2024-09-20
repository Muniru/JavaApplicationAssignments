/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section4_oop.part1_inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class AnimalSimulator {
    public static void main(String[] args) {
        AnimalSimulator anSim = new AnimalSimulator();
        anSim.start(args);
    }

    
    private void start(String[] args) {
        //YOUR CODE HERE (and remove the throw statement)
        //start processing command line arguments and run the "simulation"

        if (args.length % 2 == 1 || args.length == 0) {
            System.out.println(getHelptext());
        } else {
            // adding to list
            for (int i = 0; i < args.length; i += 2) {
                String name = "";
                if (getSupportedAnimals().contains(args[i]))
                    name = args[i];
                else{
                    StringBuilder builder = new StringBuilder();

                    builder.append("Error: animal species ")
                            .append(args[i])
                            .append(" is not known. run with single parameter \"help\" to get a listing of available species. Please give new values");
                    System.out.println(builder.toString());
                    break;
                }
                int age = 0;
                try {
                    age = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException e) {
                    System.out.println(getHelptext());
                }
                Animal animal;
                switch (name) {
                    case "Elephant":
                        animal = new Elephant(name, age);
                        break;
                    case "Tortoise":
                        animal = new Tortoise(name, age);
                        break;
                    case "Mouse":
                        animal = new Mouse(name, age);
                        break;
                    case "Horse":
                        animal = new Horse(name, age);
                        break;
                    default:
                        animal = new Animal(name, age);
                        break;
                }
                System.out.println(animal);
            }

        }
    }

    public String getHelptext(){
        StringBuilder builder = new StringBuilder();
        builder.append("Usage: java AnimalSimulator <Species age Species age ...>\n" +
                "Supported species (in alphabetical order):");
        List<String> speciesNames = getSupportedAnimals();
        for (int i = 0; i < speciesNames.size(); i++) {
            builder.append("\n" + (i + 1) + ": " + speciesNames.get(i));
        }
        return builder.toString();
    }
    
    /**
     * returns all supported animals as List, alphabetically ordered
     * @return supportedAnimals the supported animals
     */
    public List<String> getSupportedAnimals() {
        //YOUR CODE HERE (and remove the throw statement)
        List<String> animals = new ArrayList<>();
        animals.add("Elephant");
        animals.add("Horse");
        animals.add("Mouse");
        animals.add("Tortoise");
        animals.sort(String::compareTo);
        return animals;
    }
}
