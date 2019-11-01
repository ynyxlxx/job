import java.util.*;
public class Permutation {
    public static void main(String[] args){
        String test = "abc";
        ArrayList<String> res = new ArrayList<>();
        permutation(test, "", res);
        System.out.println(res);

        char[] arr = test.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        HashSet<Character> visited = new HashSet<>();
        permutation(arr, ans, path, visited);
        System.out.println(ans);

        int[] c = new int[]{1,2,3,4};
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] visit = new boolean[c.length];

//        permutation(c, temp, visit);

        permutation(c, c.length, result, temp, visit);
        System.out.println(result);
    }

    private static void permutation(String s, String ans, ArrayList<String> list){
        if (s.length() == 0){
            list.add(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String rest = s.substring(0,i) + s.substring(i + 1);
            permutation(rest, ans + ch, list);
        }
    }

    private static void permutation(char[] arr, ArrayList<String> ans, StringBuffer path, HashSet<Character> visited){
        if (path.length() == arr.length){
            ans.add(path.toString());
        }

        for (int i = 0; i < arr.length; i++){
            if (!visited.contains(arr[i])){
                path.append(arr[i]);
                visited.add(arr[i]);
                permutation(arr, ans, path, visited);
                path.deleteCharAt(path.length()-1);
                visited.remove(arr[i]);
            }
        }
    }

    private static void permutation(int[] arr, ArrayList<Integer> path, boolean[] visited){
        if (path.size() == arr.length){

            StringBuilder sb = new StringBuilder("");
            for (int i : path){
                sb.append(i + " ");
            }

            System.out.println(sb.toString());
        }

        for (int i = 0; i < arr.length; i++){
            if (visited[i] == false){
                path.add(arr[i]);
                visited[i] = true;
                permutation(arr, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static void permutation(int[] arr,int size, ArrayList<ArrayList<Integer>> res, List<Integer> path, boolean[] visited){
        if (path.size() == size){
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < arr.length; i++){
            if (visited[i] == false){
                visited[i] = true;
                path.add(arr[i]);
                permutation(arr, size, res, path, visited);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
