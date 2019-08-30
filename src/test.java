import java.util.*;

public class test {
        public static void main(String[] args){
            HashMap<String, String> map = new HashMap<>();
            Queue<String> queue = new LinkedList<>();
            Stack<String> st = new Stack<>();
            HashSet<String> set = new HashSet<>();
            LinkedList<String> linkedList = new LinkedList<>();
            ArrayList<String> arrayList = new ArrayList<>();

            char a = 'A'; // 'A' = 65, '0' = 48, 'a' = 97
            for (int i = 0; i < 26; i++){
                System.out.print((char) (97 + i));
            }

            Collections.binarySearch(new ArrayList<Integer>(), 1);

            int[] e = {1, 2, 3, 4};
            int N = e.length;
            for (int i = 0; i < N/2; i++){
                int temp = e[i];
                e[i] = e[N - 1 - i];
                e[N - 1 - i] = temp;
            }
            System.out.println(Arrays.toString(e));
        }
}

