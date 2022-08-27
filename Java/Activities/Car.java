package activities;

public class Car {
    String color = "";
    String transmission = "";
    int make =0;
    int tyres=0;
    int doors= 0;

    Car(){
        tyres = 4;
        doors = 4;
    }

    void displayCharacteristics(){
        System.out.println("Tyres: "+tyres);
        System.out.println("Doors: "+doors);
        System.out.println("Transmission: "+transmission);
        System.out.println("Color: "+color);
        System.out.println("Make: "+make);
    }
    void accelarate(){
        System.out.println("Car is moving forward.");
    }
    void brake(){
        System.out.println("Car has stopped.");
    }

}
