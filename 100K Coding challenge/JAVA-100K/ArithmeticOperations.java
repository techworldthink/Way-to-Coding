import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);

        //Main code
        System.out.println("Enter two numbers: ");
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        System.out.println("Enter the option number to perform the corresponding operation:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                float sum = num1+num2;
                System.out.println("Sum :"+sum);
                break;
            case 2:
                float difference = num1-num2;
                System.out.println("Difference :"+difference);
                break;
            case 3:
                float product = num1*num2;
                System.out.println("Product :"+product);
                break;
            case 4:
                float quotient = num1/num2;
                System.out.println("Quotient :"+quotient);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        sc.close();
    }
    
}
