package functional.model;

import java.util.function.Predicate;


public class FP09 {
	public static void main(String[] args) {
		
        Predicate<Integer> lesserthan = i -> (i < 18); 
        
        // Calling Predicate method
        System.out.println(lesserthan.test(10)); 
	}
}
