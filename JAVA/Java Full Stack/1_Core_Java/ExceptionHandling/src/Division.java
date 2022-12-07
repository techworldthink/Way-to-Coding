import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		
		int a,b,c;
		
		try{
		System.out.println("Enter two integers");
		Scanner obj = new Scanner(System.in);
		a = obj.nextInt();
		b = obj.nextInt();
		c=a/b;
		System.out.println("Result"+c);
		}catch(ArithmeticException e){
			System.out.println("Please do not enter 0");
		}finally{
			System.out.println("Finally");
		}
		
		System.out.println("More Code Can go here");

	}
}
