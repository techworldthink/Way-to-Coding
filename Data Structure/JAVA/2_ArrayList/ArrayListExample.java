import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        names.add("E");
        names.add("A");

        System.out.println(names);
        names.remove("A");
        names.remove(0);
        System.out.println(names);
    }
}
