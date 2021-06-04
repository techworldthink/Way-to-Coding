import java.util.Scanner;

public class EvenNumbers {
    public static void main (String ar[]) {
        Scanner sc = new Scanner(System.in);

        //main code
        System.out.println("Enter the limit to which even numbers are to be displayed: ");
        int limit = sc.nextInt();


        for (int i = 0; i<=limit; i++){
            if (i%2 == 0) {
                System.out.println(i+"\n");
            }
        }

        sc.close();
    }
    
}
