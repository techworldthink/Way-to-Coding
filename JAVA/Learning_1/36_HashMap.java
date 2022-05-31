import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> marks = new HashMap<String,Integer>();
        marks.put("A",123);
        marks.put("B",122);
        System.out.println(marks);
        System.out.println(marks.get("A"));
        //System.out.println(marks.remove("A"));
        //System.out.println(marks);
        System.out.println(marks.size());

        for(String i:marks.keySet()){
            System.out.println(i);
        }
        for(int i:marks.values()){
            System.out.println(i);
        }
        for(String i:marks.keySet()){
            System.out.println("key : "+i+ " value : "+marks.get(i));
        }
        marks.clear();
    }
}
