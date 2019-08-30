import java.util.*;

public class test {
        public static void main(String[] args){
            HashMap<String, String> map = new HashMap<>();
            Queue<String> queue = new LinkedList<>();
            Stack<String> st = new Stack<>();
            HashSet<String> set = new HashSet<>();
            LinkedList<String> linkedList = new LinkedList<>();

            char a = 'A'; // 'A' = 65, '0' = 48, 'a' = 97
            for (int i = 0; i < 26; i++){
                System.out.print((char) (97 + i));
            }

            Collections.binarySearch(new ArrayList<Integer>(), 1);
        }
}

