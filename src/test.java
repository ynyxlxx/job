import java.util.*;

public class test {
        public static void main(String[] args){
            HashMap<String, String> map = new HashMap<>();
            Queue<String> queue = new LinkedList<>();
            Stack<String> st = new Stack<>();
            HashSet<String> set = new HashSet<>();
            LinkedList<String> linkedList = new LinkedList<>();
            ArrayList<String> arrayList = new ArrayList<>();
            TreeSet<Integer> ts = new TreeSet<>();

            char a = 'A'; // 'A' = 65, '0' = 48, 'a' = 97
            for (int i = 0; i < 26; i++){
                System.out.print((char) (97 + i));
                if (i == 25) System.out.print("\n");
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

            int[] arr1 = {1,2,3,4,5,6,7}; //find all element in arr1 but not in arr2.
            int[] arr2 = {2,4,6};

            HashSet<Integer> hs = new HashSet<>();
            for (int i : arr2){
                hs.add(i);
            }
            for (int i : arr1){
                if (!hs.contains(i)){
                    System.out.print(i + "\t");
                }
            }

            System.out.println(Integer.MIN_VALUE);

            String[] test1 = new String("ABcdS").split("");
            System.out.println(Arrays.toString(test1));

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++){
                numbers[i] = sc.nextInt();
//            String[] temp = sc.nextLine().trim().split(" ");
//            System.out.println(Arrays.toString(temp));
            }
            System.out.println(Arrays.toString(numbers));
            

        }

}

