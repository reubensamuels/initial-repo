import java.util.Scanner;

public class Turtles {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        doesEquals(10);

    }

    public static boolean doesEquals(int potato){
        /*if(potato != 5) {
            System.out.println("Making 5 potatoes");
            potato = 5;
        }*/
        if(potato == 5){
            System.out.println("There are " + potato + " potatoes");
            return true;
        } else {
            potato = 5;
            System.out.println("There aren't 5 potatoes");
            return false;
        }
    }

}
