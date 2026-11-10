package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

import java.util.Objects;

public class Zoo {
    public static final int NBR_CAGES = 3;
    public static final int MAX_AQUATIC_ANIMALS = 10;

    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name;
    private String city;
    private int animalCount;
    private int aquaticCount;

    public Zoo() {
        animals = new Animal[NBR_CAGES];
        aquaticAnimals = new Aquatic[MAX_AQUATIC_ANIMALS];
    }

    public Zoo(String name, String city) {
        this();
        setName(name);
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: the zoo name must not be empty.");
            return;
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getAquaticCount() {
        return aquaticCount;
    }

    public void displayZoo() {
        System.out.println("Name  : " + name);
        System.out.println("City  : " + city);
        System.out.println("Cages : " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", nbrCages=" + NBR_CAGES + "]";
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("Cannot add " + animal.getName()
                    + ": an animal cannot have a negative age (" + animal.getAge() + ").");
        }
        if (animalCount >= NBR_CAGES) {
            throw new ZooFullException("Cannot add " + animal.getName()
                    + ": the zoo is full (" + NBR_CAGES + " cages).");
        }
        if (searchAnimal(animal) != -1) {
            System.out.println(animal.getName() + " is already in the zoo.");
            return;
        }
        animals[animalCount] = animal;
        animalCount++;
    }

    public void displayAnimals() {
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (Objects.equals(animals[i].getName(), animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount >= z2.animalCount) {
            return z1;
        }
        return z2;
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) {
            return;
        }
        if (aquaticCount >= MAX_AQUATIC_ANIMALS) {
            System.out.println("Error: no more room for aquatic animals.");
            return;
        }
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i].equals(aquatic)) {
                System.out.println("Error: " + aquatic.getName() + " is already in the zoo.");
                return;
            }
        }
        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
    }

    public void displayAquaticAnimals() {
        for (int i = 0; i < aquaticCount; i++) {
            System.out.println(aquaticAnimals[i]);
        }
    }

    public void swimAll() {
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float max = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > max) {
                    max = penguin.getSwimmingDepth();
                }
            }
        }
        return max;
    }

    public void displayNumberOfAquaticsByType() {
        int nbrDolphins = 0;
        int nbrPenguins = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                nbrDolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                nbrPenguins++;
            }
        }
        System.out.println("Number of dolphins : " + nbrDolphins);
        System.out.println("Number of penguins : " + nbrPenguins);
    }
}