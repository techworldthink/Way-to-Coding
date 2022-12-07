import java.util.Set;
import java.util.TreeSet;
import comparator.StringComparator;

public class StringTreeSet {
    public static void main(String[] args){

        Set<String> set =  new TreeSet<>(new StringComparator());

        set.add("abc");
        set.add("ab");
        set.add("abcd");
        set.add("z");

        for(String obj : set){
            System.out.println(obj);
        }
    }
}
