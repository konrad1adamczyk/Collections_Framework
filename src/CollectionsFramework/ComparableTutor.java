package CollectionsFramework;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *	1) Implement method Set<Animal> getAnimalsOrderedByNameSet()
 * 		and method Set<Animal> getAnimalsOrderedByNameSetDesc()
 */
public class ComparableTutor extends Tutor {
    String[] animals =
            {"Cow", "Goose", "Cat", "Dog", "Elephant",
                    "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    class Animal implements Comparable {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Object o) {

            return this.name.compareTo(o.toString());

        }

    }

    /**
     * Method should return a Set of Animal instances, alphabetically sorted
     * Use TreeSet for that and implement Comparable interface in Animal class.
     */
    public Set<Animal> getAnimalsOrderedByNameSet() {

        SortedSet set = new TreeSet();

        for (int i = 0; i < animals.length; i++) {
            Animal animal1 = new Animal(animals[i]);
            set.add(animal1);
        }

        return set;
    }


    /**
     * Method should return a Set of Animal instances,
     * ordered by the name in reverse order.
     * Use TreeSet for that and pass a Comparator implementation as a parameter.
     */
    public Set<Animal> getAnimalsOrderedByNameSetDesc() {
        SortedSet descSet;
        descSet = new TreeSet<Animal>( Collections.reverseOrder() ) ;
        for (int i = 0; i < animals.length; i++) {
            Animal animal1 = new Animal(animals[i]);
            descSet.add(animal1);
        }
        return descSet;
    }

    public String joinByCycle(Collection<?> c) {
        if (c == null) return "";
        StringBuilder builder = new StringBuilder();
        for (Object s : c) {
            builder.append(s);
            if (builder.length() > 0) builder.append(", ");
        }
        return builder.toString();
    }

    @Test
    public void testCollections() {
        log("getAnimalsList: " + joinByCycle(Arrays.asList(animals)));

        log("getAnimalsOrderedByNameSet: " + joinByCycle(getAnimalsOrderedByNameSet()));
        log("getAnimalsOrderedByNameSetDesc: " + joinByCycle(getAnimalsOrderedByNameSetDesc()));
    }

    @Test
    public void getAnimalsOrderedByNameSet_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSet();
        String join = joinByCycle(set);
        assertEquals("Cat, Chicken, Cow, Dog, Elephant, Goose, Horse, Human, Rabbit, Snake, ", join);
    }

    @Test
    public void getAnimalsOrderedByNameSetDesc_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSetDesc();
        String join = joinByCycle(set);
        assertEquals("Snake, Rabbit, Human, Horse, Goose, Elephant, Dog, Cow, Chicken, Cat, ", join);
    }
}

