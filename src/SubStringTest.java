public class SubStringTest {
    public static void main(String[] args){
        String a = "ababa";
        String b = "aba";
        System.out.println(substringCount(a, b));
    }

    private static int substringCount(String a, String b){
        int index = 0;
        // 计算出现的次数
        int count = 0;
        while((index = a.indexOf(b, index)) != -1) {
            index += 1;
            count++;
        }
        return count;

    }
}
