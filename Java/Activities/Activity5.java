package activities;
     abstract class Book{
         String title;
         public abstract void setTitle(String s);
         public String getTile(){

             return title;
        }

     }
     class MyBook extends  Book {
            @Override
            public void setTitle(String s) {
                title = s;
            }
     }
     public class Activity5 {
            public static void main(String[] args) {
                String title = "Ikigai";
                Book c= new MyBook();
                c.setTitle(title);
                System.out.println("Title: "+c.getTile());

            }
        }



