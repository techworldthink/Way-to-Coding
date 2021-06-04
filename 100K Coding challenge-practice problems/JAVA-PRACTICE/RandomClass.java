import java.util.Random;

public class RandomClass {
    public static void main(String ar[]) {

        Random random = new Random();

        int randInt = random.nextInt(6);  //Generate a random number from 0 to 5
        double randDouble = random.nextDouble(); //Generate between 0 and 1
        boolean randBool = random.nextBoolean(); // Generate true or false

        System.out.println("Random integer : "+randInt);
        System.out.println("Random double : "+randDouble);
        System.out.println("random boolean : "+randBool);
        
    }
    
}
