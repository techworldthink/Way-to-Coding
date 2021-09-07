import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        // string list
        ArrayList<String> data = new ArrayList<String>();
        data.add("Z");
        data.add("B");
        data.add("C");
        Collections.sort(data);
        System.out.println(data);
    }
}
