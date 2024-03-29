package CollectionsFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 1) Remove all entrances of word "Cow" and print the result
 * 2) Remove all entrances having 3 letters and print the result
 *
 * 3) Implement method removeIf which will take interface ShouldRemove as a parameter:
 * 		<T> List<T> removeIf(List<T> list, ShouldRemove<T> shouldRemove)
 *
 * 		This method have to iterate over the list and
 * 		remove those elements for which ShouldRemove.check() returns true
 */
interface ShouldRemove<T> {
    boolean check(T elem);
}


public class CollectionRemoveTutor extends Tutor {
    String[] animals = { "Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit",
            "Snake", "Chicken", "Horse", "Human" };

    public String joinByCycle(Collection<?> c) {
        StringBuilder builder = new StringBuilder();
        for (Object s: c) {
            builder.append(s);
            if (builder.length()>0) builder.append(", ");
        }
        return builder.toString();
    }

    public List<String> getAnimals() {
        return new ArrayList<String>(Arrays.asList(animals));
    }

    // Remove all entrances of word "Cow"
    public void unCow(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "Cow") {
                list.remove(i);
            }
        }
    }

    // Remove all entrances having 3 letters
    public void un3Letterization(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 3) {
                list.remove(i);
            }
        }
    }


    @Test
    public void testRemove() {
        List<String> list;

        list = getAnimals();
        unCow(list);
        log("list after remove: "+joinByCycle(list));

        list = getAnimals();
        un3Letterization(list);
        log("list after remove 3 letters animals: "+joinByCycle(list));
    }

    @Test
    public void unCow_emptyList_doNothing() {
        List<String> list = new ArrayList<String>();

        unCow(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void unCow_1CowList_removeCowFromList() {
        List<String> list = new ArrayList<String>();

        list.add("Cow");

        unCow(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void unCow_2CowAndAnyStringList_removeKorovaFromList() {
        List<String> list = new ArrayList<String>();

        list.add("Cow");
        list.add("anystring");
        list.add("Cow");

        unCow(list);

        assertEquals(1, list.size());
        assertEquals("anystring", list.get(0));
    }

    @Test
    public void un3Letterization_emptyList_doNothing() {
        List<String> list = new ArrayList<String>();

        un3Letterization(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void un3Letterization_1FourLettersWordList_removeFourLettersWordFromList() {
        List<String> list = new ArrayList<String>();

        list.add("333");

        un3Letterization(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void deFourLetterization_2FourLettersWordsAndAnyStringList_removeFourLettersWordsFromList() {
        List<String> list = new ArrayList<String>();

        list.add("333");
        list.add("anystring");
        list.add("333");

        un3Letterization(list);

        assertEquals(1, list.size());
        assertEquals("anystring", list.get(0));
    }
}

