import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.io.*;
public class hashMapTest {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

//        Scanner sc = new Scanner(System.in);
//        int m = Integer.parseInt(sc.nextLine());
//        for (int i= 0; i < m; i++)
//        {
//            String[] temp = sc.nextLine().trim().split(" ");
//            map.put(temp[0], Integer.parseInt(temp[1]));
//        }
//
//        System.out.println(map.entrySet());
//        Iterator iter = map.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry entry = (Map.Entry) iter.next();
//            String key = (String) entry.getKey();
//            Integer val = (Integer) entry.getValue();
//            System.out.println("key: " + key + "  val: " + val);
//        }

        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        map.put("F", 60);

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            if (entry.getKey() == "E"){
                System.out.println("find E: " + entry.getValue());
                map.put(entry.getKey(), entry.getValue() + 1);
            }
        }

        System.out.println(map.entrySet());
    }
}
