public class typecasting {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble; // Manual casting: double to int

        System.out.println(myDouble); // Outputs 9.78
        System.out.println(myInt); // Outputs 9

        int x = 7;
        // automatically converts the integer type into long type
        long y = x;
        // automatically converts the long type into float type
        float z = y;
        System.out.println("Before conversion, int value " + x);
        System.out.println("After conversion, long value " + y);
        System.out.println("After conversion, float value " + z);

        
    }
}