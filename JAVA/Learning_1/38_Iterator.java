import java.util.ArrayList;
import java.util.Iterator;

class Main {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        Iterator<String> it = cars.iterator();

        // System.out.println(it.next());
        // System.out.println(it.next());

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        while (it.hasNext()) {
            it.remove();
        }
    }
}
