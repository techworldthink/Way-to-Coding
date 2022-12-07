import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        //Main code begins
        System.out.println("Enter the two numbers to be added:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a+b;
        System.out.println("The sum is: "+sum);
        
        sc.close();
    }
}
