package CollectionsFramework;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 1) Implement methods fillAnimalsLengthMap() and printMap().
 * 		Look at the result of program execution.
 * 2) Implement methods fillLengthAnimalsMap() and printMapOfSets()
 * 		Look at the result of program execution.
 */
public class MapTutor extends Tutor {
    Map<String,Integer> animalsLengthMap = new HashMap<String, Integer>();

    Map<Integer,Set<String>> lengthAnimalsMap = new HashMap<Integer,Set<String>>();

    String [] animals =
            {"Cow", "Goose", "Cat", "Dog", "Elephant",
                    "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    /**
     * should fill the table animalsLengthMap with values
     * animal => animal.length()
     * for example
     * "Cow" => 3
     * "Snake" => 5
     */
    public void fillAnimalsLengthMap() {
        for (int i = 0; i < animals.length; i++) {
            animalsLengthMap.put(animals[i], animals[i].length());
        }

    }

    /**
     * Prints the table animalsLengthMap,
     * by printing the key and value
     */
    public void printMap(Map<?,?> map) {
    }

    /**
     * Fills table lengthAnimalsMap by values
     * animal name length => list of the animals of such a length
     * for example:
     * 3 => Cow, Dog, Cat
     *
     * 5 => Goose, Snake, Horse, Human
     * 6 => Rabbit
     */
    public void fillLengthAnimalsMap() {
        Set<String> setAnimal5 = new TreeSet();
        Set<String> setAnimal3 = new TreeSet();
        Set<String> setAnimal8 = new TreeSet();
        Set<String> setAnimal6 = new TreeSet();
        Set<String> setAnimal7 = new TreeSet();

        for (int k = 0; k < animals.length; k++) {
            if (animals[k].length() ==5){ setAnimal5.add(animals[k]); lengthAnimalsMap.put(animals[k].length(),setAnimal5);}
            if (animals[k].length() ==3){ setAnimal3.add(animals[k]); lengthAnimalsMap.put(animals[k].length(),setAnimal3);}
            if (animals[k].length() ==8){ setAnimal8.add(animals[k]); lengthAnimalsMap.put(animals[k].length(),setAnimal8);}
            if (animals[k].length() ==6){ setAnimal6.add(animals[k]); lengthAnimalsMap.put(animals[k].length(),setAnimal6);}
            if (animals[k].length() ==7){ setAnimal7.add(animals[k]); lengthAnimalsMap.put(animals[k].length(),setAnimal7);}
        }



    }

    /**
     * prints the contents of lengthAnimalsMap,
     * by printing the key and list of values
     */
    public void printMapOfSets(Map<Integer,Set<String>> map) {
    }

    @Test
    public void testMap() {
        fillAnimalsLengthMap();
        log("== printMap animalsLengthMap");
        printMap(animalsLengthMap);

        log("== printMap treemap animalsLengthMap");
        SortedMap<String, Integer> sortedMap = new TreeMap<String,Integer>(animalsLengthMap);
        printMap(sortedMap);

        log("== print lengthAnimalsMap");
        fillLengthAnimalsMap();
        printMapOfSets(lengthAnimalsMap);

        SortedMap<Integer,Set<String>> sortedMap2 = new TreeMap<Integer,Set<String>>(lengthAnimalsMap);

        log("== sortedMap headSet where key<6");
        printMapOfSets(sortedMap2.headMap(6));

        log("== sortedMap subMap 5..7");
        printMapOfSets(sortedMap2.subMap(5,7));
    }

    @Test
    public void fillAnimalsLengthMap_default_fillsAnimalsLengthMapWithData() {
        animalsLengthMap.clear();
        fillAnimalsLengthMap();
        assertEquals(3, (int) animalsLengthMap.get("Cow"));
        assertEquals(5, (int) animalsLengthMap.get("Goose"));
    }

    @Test
    public void fillLengthAnimalsMap_default_fillLengthAnimalsMapWithData() {
        lengthAnimalsMap.clear();
        fillLengthAnimalsMap();
        assertTrue(lengthAnimalsMap.get(3).contains("Cow"));
        assertTrue(lengthAnimalsMap.get(5).contains("Goose"));
    }
}

