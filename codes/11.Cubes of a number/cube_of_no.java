import java.util.*;

public class cube_of_no {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number :");
        int no = sc.nextInt();

        System.out.println("Cube of " + no + " is ");
        System.out.println(no*no*no);
    }
}