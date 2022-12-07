import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        // string list
        LinkedList<String> data = new LinkedList<String>();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        /*
        data.set(1, "BB");
        System.out.println(data);
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        data.remove(0);
        System.out.println(data);
        System.out.println(data.size());
        data.clear();

        
        data.addFirst("a");
        data.addLast("d");

        data.getFirst();
        data.getLast();

        for (String d : data) {
            System.out.println(d);
        }
        
        System.out.println(data);
        data.removeFirst();
        data.removeLast();
        */

        System.out.println("Before removing  : "+data);
        data.clear();
        System.out.println("After removing  : "+data);
    }
}
