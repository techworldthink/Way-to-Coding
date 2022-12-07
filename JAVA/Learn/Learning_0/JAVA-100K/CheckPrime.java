import java.util.Scanner;

public class CheckPrime {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        //main code

        System.out.println("Enter the number to be checked whether prime or not:");
        int num = sc.nextInt();
        int flag = 0;
        for (int i = 2; i<num/2; i++) {
            if (num%i == 0) {
                System.out.println("Not prime number");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Prime number");
        }

        sc.close();
    }
    
}
