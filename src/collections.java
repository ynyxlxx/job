import java.util.*;

public class collections {
    public static void main(String[] args){
        TreeSet<Integer> ts = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        ts.add(15);
        ts.add(8);
        ts.add(8);
        ts.add(1);
        ts.add(999);
        ts.add(55);
        ts.add(3);

        System.out.println(ts.pollLast());
        System.out.println(ts);
        Iterator<Integer> iter = ts.descendingIterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
