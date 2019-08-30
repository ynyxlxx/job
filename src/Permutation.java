import java.util.*;
public class Permutation {
    public static void main(String[] args){
        String test = "abcd";
        ArrayList<String> res = new ArrayList<>();
        permutation(test, "", res);
        System.out.println(res);
    }

    public static void permutation(String s, String ans, ArrayList<String> list){
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
}
