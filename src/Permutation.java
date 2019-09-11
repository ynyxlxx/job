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
}
