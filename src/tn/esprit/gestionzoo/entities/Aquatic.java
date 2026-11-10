package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public abstract class Aquatic extends Animal {
    protected String habitat;

    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Aquatic [family=" + family + ", name=" + name + ", age=" + age
                + ", isMammal=" + isMammal + ", habitat=" + habitat + "]";
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Aquatic)) {
            return false;
        }
        Aquatic other = (Aquatic) obj;
        return age == other.age
                && Objects.equals(name, other.name)
                && Objects.equals(habitat, other.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, habitat);
    }
}