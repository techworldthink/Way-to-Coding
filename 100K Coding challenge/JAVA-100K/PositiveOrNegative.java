import java.util.Scanner;

public class PositiveOrNegative {
    public static void main (String ar[]) {
        Scanner sc = new Scanner(System.in);

        //Main code
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        
        if (num<0) {
            System.out.println("Negative");
        } else if (num>0) {
            System.out.println("Positive");
        } else {
            System.out.println(0);
        }


        sc.close();
    }
    
}
