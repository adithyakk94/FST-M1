package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        //Creating HashMap
        HashMap<Integer,String> map=new HashMap<Integer,String>();
        //Put elements in Map
        map.put(1,"Blue");
        map.put(2,"Orange");
        map.put(3,"White");
        map.put(4,"Black");
        map.put(5,"Green");
        System.out.println("Initial Map:" +map);
        //Removing specific color
        map.remove(2);
        // Map after removing a colour
        System.out.println("After removing a color: " + map);

        // Check if green exists
        if(map.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }

        // Print the size of the Map
        System.out.println("Number of entries in the Map: " + map.size());
    }

}
