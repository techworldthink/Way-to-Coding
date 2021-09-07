import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // string list
        ArrayList<String> data = new ArrayList<String>();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        data.set(1, "BB");
        System.out.println(data);
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        data.remove(0);
        System.out.println(data);
        System.out.println(data.size());

        for (String d : data) {
            System.out.println(d);
        }
        data.clear();
        System.out.println(data);

        // numbers list
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(10);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(25);
        for (int i : myNumbers) {
          System.out.println(i);
        }
    }
}
