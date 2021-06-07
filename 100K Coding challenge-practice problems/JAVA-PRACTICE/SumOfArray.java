import java.util.Scanner;

public class SumOfArray {
    public static void main(String ar[]) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        System.out.println("Enter the number of elements you want to insert: ");
        int len = scanner.nextInt();
        int[] list = new int[len];

        System.out.println("Enter the elements to be inserted to the array:");
        for (int i = 0; i<len; i++) {
            list[i] = scanner.nextInt();
        }

        
        for (int i = 0; i<len; i++) {
            sum+=list[i];
        }
        System.out.println("The sum of all elements is: "+sum );

        scanner.close();
    }
    
}
