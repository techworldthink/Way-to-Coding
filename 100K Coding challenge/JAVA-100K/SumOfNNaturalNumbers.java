import java.util.Scanner;

public class SumOfNNaturalNumbers {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);

        //main code
        int sum = 0;

        System.out.println("Enter the limit to which you have to calculate the sum:");

        int num = sc.nextInt();
        for (int i = 1; i<=num; i++) {
            sum+=i;
        }
        System.out.println("The sum is: "+ sum);
        sc.close();
    }
    
}
