import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Main {
    public static void main(String[] args) {
        LocalDate myObj = LocalDate.now(); 
        System.out.println(myObj); 
        LocalTime myObj2 = LocalTime.now();
        System.out.println(myObj2);
        LocalDateTime myObj3 = LocalDateTime.now();
        System.out.println(myObj3);
    }
}
