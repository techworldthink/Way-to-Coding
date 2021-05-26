import java.util.Scanner;

public class UserInput {
    public static void main (String a[]) {
        //Create sc object from scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("My first java program to take a user input:");

        //User inputting a string
        System.out.println("Enter your name:");
        String name = sc.next();
        System.out.println("Hello "+name);

        //User inputting integer
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        System.out.println("You are "+age+" years old");

        //User inputting a floating point number
        System.out.println("Enter a decimal number:");
        float DecimalValue = sc.nextFloat();
        System.out.println(DecimalValue);

        sc.close();


    }
}
