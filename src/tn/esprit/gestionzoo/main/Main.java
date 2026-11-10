package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

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

        Zoo zoo2 = new Zoo("Friguia", "Hammamet");

        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(lion);

        System.out.println("\n--- Validation tests ---");
        lion.setAge(-10);
        System.out.println("Lion age: " + lion.getAge());
        myZoo.setName("");
        System.out.println("Zoo name: " + myZoo.getName());

        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal lionCopy = new Animal("Felidae", "Simba", 5, true);
        Animal badAnimal = new Animal("Canidae", "Rex", -3, true);
        Animal elephant = new Animal("Elephantidae", "Dumbo", 10, true);
        Animal giraffe = new Animal("Giraffidae", "Melman", 6, true);

        Animal[] animalsToAdd = {lion, tiger, lionCopy, badAnimal, elephant, giraffe};

        System.out.println("\n--- Instructions 33 & 34: addAnimal with exceptions ---");
        for (Animal animal : animalsToAdd) {
            try {
                myZoo.addAnimal(animal);
            } catch (ZooFullException e) {
                System.out.println("ZooFullException: " + e.getMessage());
            } catch (InvalidAgeException e) {
                System.out.println("InvalidAgeException: " + e.getMessage());
            } finally {
                System.out.println("Number of animals: " + myZoo.getAnimalCount());
            }
        }

        System.out.println("\n--- Animals in the zoo ---");
        myZoo.displayAnimals();
        System.out.println("Zoo full? " + myZoo.isZooFull());
        System.out.println("Index of lion: " + myZoo.searchAnimal(lion));

        System.out.println("\n--- Remove ---");
        System.out.println("Remove tiger: " + myZoo.removeAnimal(tiger));
        System.out.println("Number of animals: " + myZoo.getAnimalCount());
        System.out.println("Zoo full? " + myZoo.isZooFull());

        System.out.println("\n--- Compare ---");
        try {
            zoo2.addAnimal(tiger);
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Number of animals in " + zoo2.getName() + ": " + zoo2.getAnimalCount());
        }
        System.out.println("Zoo with most animals: " + Zoo.compareZoo(myZoo, zoo2).getName());

        System.out.println("\n--- Prosit 5 ---");
        Terrestrial terrestrial = new Terrestrial("Felidae", "Tom", 4, true, 4);
        Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        System.out.println("\n--- Prosit 6 ---");
        Dolphin dolphin2 = new Dolphin("Delphinidae", "Echo", 5, true, "Mediterranean", 40.0f);
        Penguin penguin2 = new Penguin("Spheniscidae", "Skipper", 6, false, "Antarctica", 250.5f);
        Penguin penguin3 = new Penguin("Spheniscidae", "Rico", 2, false, "Patagonia", 80.0f);
        Aquatic aquatic = new Dolphin("Delphinidae", "Nemo", 10, true, "Pacific", 30.0f);

        myZoo.addAquaticAnimal(dolphin);
        myZoo.addAquaticAnimal(penguin);
        myZoo.addAquaticAnimal(dolphin2);
        myZoo.addAquaticAnimal(penguin2);
        myZoo.addAquaticAnimal(penguin3);
        myZoo.addAquaticAnimal(aquatic);
        myZoo.displayAquaticAnimals();

        myZoo.swimAll();
        System.out.println("Max depth: " + myZoo.maxPenguinSwimmingDepth());
        myZoo.displayNumberOfAquaticsByType();

        Penguin pinguCopy = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 50.0f);
        Penguin pinguOtherHabitat = new Penguin("Spheniscidae", "Pingu", 3, false, "Arctic", 120.0f);
        System.out.println("penguin equals pinguCopy: " + penguin.equals(pinguCopy));
        System.out.println("penguin equals pinguOtherHabitat: " + penguin.equals(pinguOtherHabitat));
        myZoo.addAquaticAnimal(pinguCopy);
        System.out.println("Aquatic count: " + myZoo.getAquaticCount());
    }
}