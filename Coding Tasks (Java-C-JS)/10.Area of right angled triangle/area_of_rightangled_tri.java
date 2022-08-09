import java.util.*;

public class area_of_rightangled_tri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the breadth of triangle: ");
        int b = sc.nextInt();
        System.out.println("Enter the height of triangle: ");
        int h = sc.nextInt();

        System.out.println("Area : ");
        System.out.println(.5*b*h);
    }
}