import java.util.Scanner;

public class SimpleInterest {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);

        //Main code
        System.out.print("Enter the pricipal amount:");
        int amount = sc.nextInt();
        System.out.print("Enter the interest rate:");
        int rate = sc.nextInt();
        System.out.print("Enter the time in years:");
        int time = sc.nextInt();

        float simpleInterest = (amount*rate*time)/100;
        System.out.println("The total interest you have to pay is:"+simpleInterest);


        sc.close();
    }
    
}
