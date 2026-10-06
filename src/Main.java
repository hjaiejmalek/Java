public class Main {
    public static void main(String[] args) {
        Animal lion = new Animal();
        lion.family = "Felidae";
        lion.name = "Simba";
        lion.age = 5;
        lion.isMammal = true;

        Zoo myZoo = new Zoo();
        myZoo.name = "Belvedere";
        myZoo.city = "Tunis";

        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Zoo zoo2 = new Zoo("Friguia", "Hammamet");

        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion);

        System.out.println(myZoo.addAnimal(lion));
        System.out.println(myZoo.addAnimal(tiger));

        myZoo.displayAnimals();
        System.out.println(myZoo.searchAnimal(lion));
        Animal lionCopy = new Animal("Felidae", "Simba", 5, true);
        System.out.println(myZoo.searchAnimal(lionCopy));

        System.out.println(myZoo.addAnimal(lionCopy));
        for (int i = 1; i <= 30; i++) {
            myZoo.addAnimal(new Animal("Family" + i, "Animal" + i, i, true));
        }
        System.out.println(myZoo.animalCount);

        System.out.println(myZoo.removeAnimal(tiger));

        System.out.println(myZoo.isZooFull());

        zoo2.addAnimal(tiger);
        System.out.println(Zoo.compareZoo(myZoo, zoo2).name);
    }
}
