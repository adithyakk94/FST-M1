package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        //Creating arraylist
        ArrayList<String> myList = new ArrayList<String>();
        //Adding object in arraylist
        myList.add("James");
        myList.add("Jasmine");
        myList.add("Sara");
        myList.add("Esther");
        myList.add("Vinay");
        for(String name : myList){
            System.out.println(name);
        }

        System.out.println("Third name in array list: "+ myList.get(3));
        //Search for element
        System.out.println("Check that Jasmine is available in the list or not: " + myList.contains("Jasmine"));
        System.out.println("Number of names in the ArrayList: "+ myList.size());
        //Removing specific element
        myList.remove("James");
        System.out.println("New Size of ArrayList: "+ myList.size());
        //Print updated ArrayList
        System.out.println("New ArrayList: "+ myList);
    }
}