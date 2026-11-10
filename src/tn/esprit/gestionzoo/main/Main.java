package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Animal();
        lion.setFamily("Felidae");
        lion.setName("Simba");
        lion.setAge(5);
        lion.setMammal(true);

        Zoo myZoo = new Zoo();
        myZoo.setName("Belvedere");
        myZoo.setCity("Tunis");

        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Zoo zoo2 = new Zoo("Friguia", "Hammamet");

        // Display
        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(lion);

        System.out.println("\n--- Validation tests ---");
        Animal badAnimal = new Animal("Canidae", "Rex", -3, true);
        System.out.println(badAnimal);
        lion.setAge(-10);
        System.out.println("Lion age: " + lion.getAge());
        myZoo.setName("");
        System.out.println("Zoo name: " + myZoo.getName());

        System.out.println("\n--- Add & search ---");
        System.out.println("Add lion: " + myZoo.addAnimal(lion));
        System.out.println("Add tiger: " + myZoo.addAnimal(tiger));
        myZoo.displayAnimals();
        System.out.println("Index of lion: " + myZoo.searchAnimal(lion));

        Animal lionCopy = new Animal("Felidae", "Simba", 5, true);
        System.out.println("Index of lion copy: " + myZoo.searchAnimal(lionCopy));
        System.out.println("Add lion copy (duplicate): " + myZoo.addAnimal(lionCopy));

        // Instruction 17: fill the zoo, addAnimal stops at 25
        System.out.println("\n--- Fill the zoo ---");
        for (int i = 1; i <= 30; i++) {
            myZoo.addAnimal(new Animal("Family" + i, "Animal" + i, i, true));
        }
        System.out.println("Animal count: " + myZoo.getAnimalCount());
        System.out.println("Zoo full? " + myZoo.isZooFull());
        System.out.println("Add when full: " + myZoo.addAnimal(new Animal("X", "Extra", 1, false)));


        System.out.println("\n--- Remove ---");
        System.out.println("Remove tiger: " + myZoo.removeAnimal(tiger));
        System.out.println("Animal count: " + myZoo.getAnimalCount());
        System.out.println("Zoo full? " + myZoo.isZooFull());


        System.out.println("\n--- Compare ---");
        zoo2.addAnimal(tiger);
        System.out.println("Zoo with most animals: " + Zoo.compareZoo(myZoo, zoo2).getName());


        System.out.println("\n--- Instruction 21: default constructors ---");
        Aquatic aquatic = new Aquatic();
        Terrestrial terrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();
        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        aquatic = new Aquatic("Cetacea", "Moby", 12, true, "Ocean");
        terrestrial = new Terrestrial("Felidae", "Tom", 4, true, 4);
        dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
        penguin = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);

        System.out.println("\n--- Instruction 23: toString() ---");
        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        System.out.println("\n--- Instruction 24: swim() ---");
        aquatic.swim();
        dolphin.swim();
        penguin.swim();
    }
}