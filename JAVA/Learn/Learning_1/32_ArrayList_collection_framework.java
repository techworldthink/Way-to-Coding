import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        // string list
        ArrayList<String> data = new ArrayList<String>();
        // add 
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        // change 
        data.set(1, "BB");
        System.out.println(data);

        // get 
        System.out.println(data.get(0));
        System.out.println(data.get(1));

        // remove
        data.remove(0);
        System.out.println(data);

        // size         
        System.out.println(data.size());

        // traversing
        for (String d : data) {
            System.out.println(d);
        }


        // sort
        Collections.sort(data);
        System.out.println(data);

        // clear
        data.clear();
        System.out.println(data);
    }
}
