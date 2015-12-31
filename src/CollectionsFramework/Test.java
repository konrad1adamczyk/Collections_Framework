package CollectionsFramework;

import java.util.HashSet;
import java.util.*;

/**
 * Created by KAdamczyk on 2015-12-17.
 */
public class Test {

    {

        Map<String,Integer> animalsLengthMap = new HashMap<String, Integer>();
//        Map<Integer,Set<String>> lengthAnimalsMap = new HashMap<Integer,Set<String>>();
        Map<Integer,String> lengthAnimalsMap = new HashMap<Integer,String>();

        String [] animals = {"Cow", "Goose", "Cat", "Dog", "Elephant",
                        "Rabbit", "Snake", "Chicken", "Horse", "Human"};

            for (int i = 0; i < animals.length; i++) {
                animalsLengthMap.put(animals[i], animals[i].length());
            }
        Set set1 = animalsLengthMap.keySet();
        System.out.println(set1);
        System.out.println("********************");
        Set set2 = animalsLengthMap.entrySet();
        System.out.println(set2);


        Set<String> setAnimal = new TreeSet();

        Collection values = animalsLengthMap.values();
        Integer[] table = (Integer[]) values.toArray();

        for (int k = 0; k < animals.length; k++) {

            setAnimal.add(animals[k]);
        }

        for (int i = 0; i < animals.length; i++) {

            lengthAnimalsMap.put(table[i], animals[i]);
        }


        System.out.println("********************");
        System.out.println(lengthAnimalsMap);

//        String [] animals =  {"Cow", "Goose", "Cow", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human"};
//
//        List list = new ArrayList<String>(Arrays.asList(animals));
//        System.out.println(list);
//
//        Collections.sort(list);



//        list.remove("Cow");
//        for (Object s: list) {
//            if (s=="Cow"){
//                list.remove(s);
//            }
//        }
//        System.out.println(list);


//        for(int i=0; i< list.size();	i++)
//        {
//           if(list.get(i)=="Cow"){
//               list.remove(i);
//           }
//        }

//        System.out.println(list);


    }

}
