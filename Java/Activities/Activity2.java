package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] array = {10, 77, 10, 54, -11, 10};
        Activity2 activity =  new Activity2();
        activity.result(array);

    }
    public boolean result(int[] array) {
        int sum = 0;
        for (int i = 0; i <= 5; i++) {
            if (array[i] == 10) {
                sum = sum + array[i];
            }
        }
        if (sum == 30) {
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;

    }
}
