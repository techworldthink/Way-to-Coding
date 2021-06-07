import java.util.Scanner;

public class BiggerOfTwoNumbers {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if (num1>num2) {
            System.out.println(num1+" is greatest");

        } else if (num2>num1) {
            System.out.println(num2 + " is greatest");
        } else {
            System.out.println("Both are equal");
        }

        sc.close();
    }
}
