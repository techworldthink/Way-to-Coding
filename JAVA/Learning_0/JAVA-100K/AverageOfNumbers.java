import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        //Main code

        System.out.println("Enter three numbers to find their average:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int avg = (num1+num2+num3)/3;
        System.out.println("The average is :"+avg);

        sc.close();
        
    }
    
}
