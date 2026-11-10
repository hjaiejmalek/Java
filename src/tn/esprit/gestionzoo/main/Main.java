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

        System.out.println("\n--- Prosit 5 ---");
        Terrestrial terrestrial = new Terrestrial("Felidae", "Tom", 4, true, 4);
        Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        System.out.println("\n--- Instruction 26: add aquatic animals ---");
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

        System.out.println("\n--- Instruction 27: swim() for all aquatic animals ---");
        myZoo.swimAll();

        System.out.println("\n--- Instruction 29: max penguin swimming depth ---");
        System.out.println("Max depth: " + myZoo.maxPenguinSwimmingDepth());

        System.out.println("\n--- Instruction 30: number of aquatics by type ---");
        myZoo.displayNumberOfAquaticsByType();

        System.out.println("\n--- Instruction 31: equals() ---");
        Penguin pinguCopy = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 50.0f);
        Penguin pinguOtherHabitat = new Penguin("Spheniscidae", "Pingu", 3, false, "Arctic", 120.0f);
        System.out.println("penguin equals pinguCopy: " + penguin.equals(pinguCopy));
        System.out.println("penguin equals pinguOtherHabitat: " + penguin.equals(pinguOtherHabitat));
        myZoo.addAquaticAnimal(pinguCopy);
        System.out.println("Aquatic count: " + myZoo.getAquaticCount());
    }
}