import util.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        names.insert("A");
        names.insert("B");
        names.insert("C");

        names.traverse();
        names.remove("A");
        names.traverse();
    }
}
