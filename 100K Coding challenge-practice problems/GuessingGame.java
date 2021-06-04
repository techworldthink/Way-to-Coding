import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String ar[]) {
        //Creating instances
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter the limit below which number is to be selected:");

        int limit = scanner.nextInt();
        int num = random.nextInt(limit);

        System.out.println("You have total 5 attempts");

        for (int i = 0; i<5; i++) {
            System.out.println("Enter your guess:");
            int guess = scanner.nextInt();
            if (guess == num) {
                System.out.println("You guessed it right!!!\n It was "+num);
                break;
            } else if (guess<num) {
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }
        }


      
        scanner.close();
    }
    
}
