import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        HashSet<String> marks = new HashSet<String>();
        marks.add("A");
        marks.add("B");
        marks.add("B"); // must  be unique
        System.out.println(marks);
        System.out.println(marks.contains("A"));
        //marks.remove("A");
        //System.out.println(marks.size());

       for(String i:marks){
            System.out.println(i);
       }

        marks.clear();
    }
}
