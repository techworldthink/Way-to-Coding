import java.util.Scanner;

public class StarPattern {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        //main code

        System.out.println("Enter the number of rows required:");

        int num = sc.nextInt();
        //Normal
        for (int i = 0; i<num; i++) {
            for (int j = 0; j<=i; j++) {
                System.out.print("*\t");
            }
            System.out.println("\n");
        }

        //Upside down
        for (int i = 0; i<num; i++) {
            for (int j = num; j>i; j--) {
                System.out.print("*\t");
            }
            System.out.println("\n");
        }
        sc.close();
    }
    
}
