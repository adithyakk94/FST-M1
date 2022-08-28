package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        //Creating Hashset
        HashSet<String> hs = new HashSet<String>();
        //Adding object in Hashset
            hs.add("Mathew");
            hs.add("Jasmine");
            hs.add("Sara");
            hs.add("Esther");
            hs.add("Vinay");
            hs.add("Jacob");
        System.out.println("An initial list of elements: "+hs);
        System.out.println("Size of Hashset: "+ hs.size());
        //Removing specific element from HashSet
            hs.remove("Jasmine");
        //Removing element that is not present in the Set
        if(hs.remove("Cath")) {
            System.out.println("Cath removed from the Set");
        } else {
            System.out.println("Cath is not present in the Set");
        }
        //Search for element
        System.out.println("Check that Sara is available in the set or not: " + hs.contains("Sara"));
        //Print updated HashSet
        System.out.println("Updated Set: "+hs);

    }

}
