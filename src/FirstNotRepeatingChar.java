import java.util.HashMap;

public class FirstNotRepeatingChar {
    public static void main(String[] args){
        String a = "hhhhhh7k";
        int index = FirstNotRepeatingChar(a);
        System.out.println(a.charAt(index));
    }

    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
            }else{
                int temp = map.get(str.charAt(i));
//                map.remove(str.charAt(i));
                map.put(str.charAt(i), temp + 1);
            }
        }

        for(int i = 0;i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
