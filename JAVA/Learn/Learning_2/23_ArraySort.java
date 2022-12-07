import java.util.Arrays;

public class ArraysSort {

	public static void main(String[] args) {
		int[] a = {40,10,15,7};
		
		System.out.println("Before sort : ");
		for(int each : a) {
			System.out.println(each);
		}
		
		Arrays.sort(a);
		
		System.out.println("After sort : ");
		for(int each : a) {
			System.out.println(each);
		}

	}

}
