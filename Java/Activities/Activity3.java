package activities;

public class Activity3 {
    double seconds = 1000000000;
    double EarthSeconds = 31557600;
    double MercurySeconds = 0.2408467;
    double VenusSeconds = 0.61519726;
    double MarsSeconds = 1.8808158;
    double JupiterSeconds = 11.862615;
    double SaturnSeconds = 29.447498;
    double UranusSeconds = 84.016846;
    double NeptuneSeconds = 164.79132;

    public static void main(String[] args) {

        Activity3 activity = new Activity3();
        activity.earthAge();
        activity.mercuryAge();
        activity.venusAge();
        activity.marsAge();
        activity.jupiterAge();
        activity.saturmnAge();
        activity.uranusAge();
        activity.neptuneAge();

    }
        public void earthAge(){
           double age = seconds/EarthSeconds;
            System.out.println("Earth Age:"+age);
        }
        public  void mercuryAge(){
            double age = seconds/EarthSeconds/MercurySeconds;
            System.out.println("Mercury Age:"+age);

        }
    public  void venusAge(){
        double age = seconds/EarthSeconds/VenusSeconds;
        System.out.println("Venus Age:"+age);

    }
    public  void marsAge() {
        double age = seconds / EarthSeconds / MarsSeconds;
        System.out.println("Mars Age:" + age);
    }
        public  void jupiterAge(){
            double age = seconds/EarthSeconds/JupiterSeconds;
            System.out.println("Jupiter Age:"+age);

        }
        public  void saturmnAge(){
            double age = seconds/EarthSeconds/SaturnSeconds;
            System.out.println("Saturn Age:"+age);

        }
        public  void uranusAge(){
            double age = seconds/EarthSeconds/UranusSeconds;
            System.out.println("Uranus Age:"+age);

        }
        public  void neptuneAge(){
            double age = seconds/EarthSeconds/NeptuneSeconds;
            System.out.println("Neptune Age:"+age);

        }



}
