/*

-> Widening Casting
    -> byte -> short -> char -> int -> long -> float -> double

-> Narrowing Casting
    -> double -> float -> long -> int -> char -> short -> byte
*/

class typecasting {
    public static void main(String[] args) {
        // Widening
        // -> Implicit
        int myInt = 9;
        double myDouble = myInt;
        System.out.println(myInt);      
        System.out.println(myDouble);   

        // Narrowing
        // -> Explicit
        double myDouble2 = 9.78d;
        int myInt2 = (int) myDouble2; 
    
        System.out.println(myDouble2);   
        System.out.println(myInt2);    
    }
}
