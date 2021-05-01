import java.util.*;
public class user_input{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter name :");
        String name = sc.nextLine();
        System.out.println("Enter ID :");
        int ID = sc.nextInt();

        System.out.println("Name : " +name+ "\nID :" +ID ); 
    }
}