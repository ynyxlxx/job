import java.lang.reflect.Array;
import java.util.Arrays;

public class Reverse {
    public static void main(String[] args){
        String a = "student. a am I";
        String b = reverseAll(a);
        System.out.println(a);
        System.out.println(b);

    }
    public static String reverseAll(String str){
        String t = reverse(str);
        String[] temp = t.split(" ");
        StringBuffer sb = new StringBuffer();
        System.out.println(Arrays.toString(temp));

        for (String s : temp)
            sb.append(reverse(s) + " ");

        return sb.toString().trim();
    }

    public static String reverse(String str){
        String res = "";
        int i = str.length() - 1;
        while (i >= 0) {
            char temp = str.charAt(i);
            res += temp;
            i--;
        }
        return res;
    }
}
