import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);

        //Main code
        System.out.println("Enter the numbers to be swapped :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("Numbers after swapping is:"+a+" and "+b);

        sc.close();

    }
    
}
